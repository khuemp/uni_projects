/** Type checking with variability.
  */
package de.uni_saarland.cs.se

import Constant.*
import Type.*
import VExpression.*

import cafesat.api.Formulas.Formula
import cafesat.api.{Formulas, Solver}

/** Variability context as in lecture slides 74.
  */
case class VariabilityContext(formula: Formula) {

  /** Make equality consider logical equality of formulas.
    */
  override def equals(obj: Any): Boolean = {
    obj match {
      case other: VariabilityContext =>
        Solver.solveForSatisfiability(!(formula iff other.formula)) match {
          case Some(_) => false
          case None    => true
        }
      case _ => false
    }
  }

  override def toString: String = formula.toString
}

object VariabilityContext {

  /** Creates an empty variability context.
    */
  def emptyContext(): VariabilityContext = new VariabilityContext(Formulas.True)

  /** Allow implicit conversion from formulas to `VariabilityContext`.
    */
  given formulaToVarCtx: Conversion[Formula, VariabilityContext] =
    VariabilityContext(_)
}

/** Type alias for type context type */
type VTypeContext = TypeContext[Identifier, VType]

/** Type alias for context (= variability context + type context) type */
type VContext = (VariabilityContext, VTypeContext)

/** Type alias for result type */
type VResult = TypeCheckResult[VExpression, VType, VContext]

object VariabilityTypeChecker {

  /** Type-check a single expression.
    */
  def checkType(
      expr: VExpression,
      context: VContext = createContext()
  ): VResult = {
    new VariabilityTypeChecker().checkType(expr, context)
  }

  /** Simplify creation of variability context + type context.
    */
  def createContext(
      variabilityContext: VariabilityContext =
        VariabilityContext.emptyContext(),
      typeContext: VTypeContext = TypeContext()
  ): VContext = (variabilityContext, typeContext)
}

/** Type checker implementation for the language with variability.
  */
class VariabilityTypeChecker extends TypeChecker[VExpression, VType, VContext] {

  override def checkType(expr: VExpression, context: VContext): VResult = {
    // TODO: implement task b)
    expr match {
      case Const(c) =>
        c match {
          case True =>
            return Success((VType(BoolTy -> context._1.formula)))
          case False =>
            return Success((VType(BoolTy -> context._1.formula)))
          case Num(value) =>
            if value.isInstanceOf[Int] then
              return Success((VType(NumTy -> context._1.formula)))
            else return Failure(expr, context)
          case null =>
            return Failure(expr, context)
        }

      case Id(id) =>
        context._2.typeForVar(id) match {
          case Some(idType) =>
            return Success(idType)
          case None =>
            return Failure(expr, context)
        }

      case Smaller(lhs, rhs) =>
        if (VariabilityTypeChecker.checkType(lhs, context) equals (Success(VType(NumTy -> context._1.formula)))) &&
          (VariabilityTypeChecker.checkType(rhs, context) equals (Success(VType(NumTy -> context._1.formula)))) then
          return Success(VType(BoolTy -> context._1.formula))
        return Failure(expr, context)

      case If(condition, thenExpr, elseExpr) =>
        val t2 = VariabilityTypeChecker.checkType(thenExpr, context)
        val t3 = VariabilityTypeChecker.checkType(elseExpr, context)
        if (VariabilityTypeChecker.checkType(condition, context) equals (Success(VType(BoolTy -> context._1.formula)))) &&
          (t2 equals (t3)) then
          return t2
        return Failure(expr, context)

      case Let(variable, varValue, inExpr) =>
        if context._2.typeForVar(variable) != None then
          return Failure(expr, context)
        val t1 = VariabilityTypeChecker.checkType(varValue, context)
        var newTypeCxt : VTypeContext = null
        if t1 equals Success(VType(BoolTy -> context._1.formula)) then
          newTypeCxt = context._2.withVar(variable, VType(BoolTy -> context._1.formula))
        else if t1 equals Success(VType(NumTy -> context._1.formula)) then
          newTypeCxt = context._2.withVar(variable, VType(NumTy -> context._1.formula))
        else
          return Failure(expr, context)
        val newCxt = (context._1, newTypeCxt)
        return VariabilityTypeChecker.checkType(inExpr, newCxt)

      case Choice(presenceCondition, trueChoice, falseChoice) =>
        val newFormula1 : VariabilityContext = new VariabilityContext(context._1.formula.&&(presenceCondition))
        val newFormula2 : VariabilityContext = new VariabilityContext(context._1.formula.&&(presenceCondition.unary_!))
        val newCxt1 : VContext = (newFormula1, context._2)
        val newCxt2 : VContext = (newFormula2, context._2)
        val t1 = VariabilityTypeChecker.checkType(trueChoice, newCxt1)
        val t2 = VariabilityTypeChecker.checkType(falseChoice, newCxt2)
        if t1 equals(Success(VType(NumTy -> newCxt1._1.formula))) then
          if t2 equals(Success(VType(NumTy -> newCxt2._1.formula))) then
            return Success(VType(NumTy -> newCxt1._1.formula, NumTy -> newCxt2._1.formula))
          if t2 equals(Success(VType(BoolTy -> newCxt2._1.formula))) then
            return Success(VType(NumTy -> newCxt1._1.formula, BoolTy -> newCxt2._1.formula))
        if t1 equals(Success(VType(BoolTy -> newCxt1._1.formula))) then
          if t2 equals(Success(VType(NumTy -> newCxt2._1.formula))) then
            return Success(VType(BoolTy -> newCxt1._1.formula, NumTy -> newCxt2._1.formula))
          if t2 equals(Success(VType(BoolTy -> newCxt2._1.formula))) then
            return Success(VType(BoolTy -> newCxt1._1.formula, BoolTy -> newCxt2._1.formula))
        return Failure(expr, context)
    }
  }
}