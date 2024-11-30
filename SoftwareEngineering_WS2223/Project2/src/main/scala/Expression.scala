/** This file implements our simple programming language as defined in the
  * lecture.
  */
package de.uni_saarland.cs.se

import cafesat.api.Formulas.Formula
import cafesat.api.{Formulas, Solver}

import scala.language.implicitConversions

/** Constants
  */
enum Constant:
  case True
  case False
  case Num(value: Int)

/** Identifiers
  */
case class Identifier(name: String) {
  override def toString: String = name
}

/** Types
  */
enum Type:
  case NumTy
  case BoolTy

/** Expressions for the language without variability (cf. slides 70/71).
  */
enum Expression {
  case Const(c: Constant)
  case Id(id: Identifier)
  case Smaller(lhs: Expression, rhs: Expression)
  case If(condition: Expression, thenExpr: Expression, elseExpr: Expression)
  case Let(variable: Identifier, varValue: Expression, inExpr: Expression)

  def _lt(expression: Expression): Smaller = Smaller(this, expression)
}

/** Expressions for the language with variability (cf. slides 72-74).
  */
enum VExpression {
  case Const(c: Constant)
  case Id(id: Identifier)
  case Smaller(lhs: VExpression, rhs: VExpression)
  case If(condition: VExpression, thenExpr: VExpression, elseExpr: VExpression)
  case Let(variable: Identifier, varValue: VExpression, inExpr: VExpression)
  case Choice(
      presenceCondition: Formula,
      trueChoice: VExpression,
      falseChoice: VExpression
  )

  def _lt(expression: VExpression): Smaller = Smaller(this, expression)
}

/** VType: Types with variability.
  *
  * VTypes map types to their presence condition.
  */
class VType(val types: Map[Type, Formula] = Map()) {

  /** Returns the domain of this VType.
    */
  def dom(): Set[Type] = types.keys.toSet

  /** Retrieve the formula associated with a certain type.
    */
  def formulaForType(t: Type): Option[Formula] = types.get(t)

  override def toString: String = {
    types.toSeq
      .map({ case (t: Type, pc: Formula) =>
        s"($t => $pc)"
      })
      .mkString("\n")
  }

  /** Make equality consider logical equality of formulas.
    */
  override def equals(obj: Any): Boolean = {
    obj match {
      case typeB: VType =>
        if (dom() == typeB.dom()) {
          dom().forall(t => {
            val formulaA = formulaForType(t).get
            val formulaB = typeB.formulaForType(t).get
            Solver.solveForSatisfiability(!(formulaA iff formulaB)) match {
              case Some(_) => false
              case None    => true
            }
          })
        } else {
          false
        }
      case _ => false
    }
  }
}

/** Magic function so that we can write `VType(NumTy -> Formulas.True)` instead
  * of `new VType(Map(NumTy -> Formulas.True))`.
  */
object VType {
  def apply(elems: (Type, Formula)*): VType = new VType(Map.from(elems))
}

/*
 * Everything below here is only there to allow writing expressions in a nicer
 * syntax but is irrelevant for implementing the type checker.
 */

object Expression {
  given intToConst: Conversion[Int, Constant]              = Constant.Num(_)
  given constantToExpr: Conversion[Constant, Expression]   = Expression.Const(_)
  given intToExpr: Conversion[Int, Expression]             = Expression.Const(_)
  given stringToIdentifier: Conversion[String, Identifier] = Identifier(_)
  given identifierToExpr: Conversion[Identifier, Expression] = Expression.Id(_)
  given stringToExpr: Conversion[String, Expression]         = Expression.Id(_)

  def _if(cond: Expression): IfThen = IfThen(cond)

  def _let(varName: Identifier): LetIs = LetIs(varName)
}

case class IfThen(cond: Expression) {
  def _then(expr: Expression): IfElse = IfElse(cond, expr)
}

case class IfElse(cond: Expression, thenExpr: Expression) {
  def _else(expr: Expression): Expression.If =
    Expression.If(cond, thenExpr, expr)
}

case class LetIs(varName: Identifier) {
  def _is(expr: Expression): LetIn = LetIn(varName, expr)
}

case class LetIn(varName: Identifier, varExpr: Expression) {
  def _in(expr: Expression): Expression.Let =
    Expression.Let(varName, varExpr, expr)
}

object VExpression {
  given intToConst: Conversion[Int, Constant]             = Constant.Num(_)
  given constantToExpr: Conversion[Constant, VExpression] = VExpression.Const(_)
  given intToExpr: Conversion[Int, VExpression]           = VExpression.Const(_)
  given stringToIdentifier: Conversion[String, Identifier] = Identifier(_)
  given identifierToExpr: Conversion[Identifier, VExpression] =
    VExpression.Id(_)
  given stringToExpr: Conversion[String, VExpression] = VExpression.Id(_)

  def _if(cond: VExpression): VIfThen = VIfThen(cond)

  def _let(varName: Identifier): VLetIs = VLetIs(varName)
}

case class VIfThen(cond: VExpression) {
  def _then(expr: VExpression): VIfElse = VIfElse(cond, expr)
}

case class VIfElse(cond: VExpression, thenExpr: VExpression) {
  def _else(expr: VExpression): VExpression.If =
    VExpression.If(cond, thenExpr, expr)
}

case class VLetIs(varName: Identifier) {
  def _is(expr: VExpression): VLetIn = VLetIn(varName, expr)
}

case class VLetIn(varName: Identifier, varExpr: VExpression) {
  def _in(expr: VExpression): VExpression.Let =
    VExpression.Let(varName, varExpr, expr)
}
