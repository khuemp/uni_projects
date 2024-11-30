/** Type checking without variability.
  */
package de.uni_saarland.cs.se

import Constant.*
import Expression.*
import Type.*

/** Type context as in lecture slides 71/74.
  *
  * @tparam IdT
  *   type used for variables
  * @tparam TypeT
  *   the types of the language
  */
case class TypeContext[IdT, TypeT] private (mapping: Map[IdT, TypeT]) {

  /** Create an extended copy of this type context that sets the type for the
    * given variable.
    */
  def withVar(id: IdT, value: TypeT): TypeContext[IdT, TypeT] = {
    new TypeContext(mapping updated (id, value))
  }

  /** Get the type for a given variable.
    */
  def typeForVar(id: IdT): Option[TypeT] = mapping.get(id)

  override def toString: String = {
    mapping.toSeq
      .map({ case (id: IdT, t: TypeT) =>
        s"($id: $t)"
      })
      .mkString("\n")
  }
}

object TypeContext {

  /** Magic function so that we can write 
    * `TypeContext(("x", VType(BoolTy -> * A)))` instead of
    * `new TypeContext(Map("x", VType(BoolTy -> A)))`.
    */
  def apply[IdT, TypeT](elems: (IdT, TypeT)*): TypeContext[IdT, TypeT] =
    new TypeContext(Map.from(elems))
}

/** Type alias for context type, i.e., the type context. */
type Context = TypeContext[Identifier, Type]

/** Type alias for result type. */
type Result = TypeCheckResult[Expression, Type, Context]

object SimpleTypeChecker {

  /** Type-check a single expression.
    */
  def checkType(
      expr: Expression,
      context: Context = TypeContext()
  ): Result = {
    new SimpleTypeChecker().checkType(expr, context)
  }
}

/** Type checker implementation for the language without variability.
  */
class SimpleTypeChecker extends TypeChecker[Expression, Type, Context] {

  override def checkType(expr: Expression, context: Context): Result = {
    // DONE: implement task a)
    expr match {
      case Const(c) =>
        c match {
          case True =>
            return Success(BoolTy)
          case False =>
            return Success(BoolTy)
          case Num(value) =>
            if value.isInstanceOf[Int] then
              return Success(NumTy)
            else return Failure(expr, context)
          case null =>
            return Failure(expr, context)
            }
        
      case Id(id) =>
        context.typeForVar(id) match {
          case Some(idType) =>
            return Success(idType)
          case None =>
            return Failure(expr, context)
        }
        
      case Smaller(lhs, rhs) =>
        if (SimpleTypeChecker.checkType(lhs, context) equals(Success(NumTy))) &&
          (SimpleTypeChecker.checkType(rhs, context) equals(Success(NumTy))) then
          return Success(BoolTy)
        return Failure(expr, context)
        
      case If(condition, thenExpr, elseExpr) =>
        val t2 : Result = SimpleTypeChecker.checkType(thenExpr, context)
        val t3 : Result = SimpleTypeChecker.checkType(elseExpr, context)
        if (SimpleTypeChecker.checkType(condition, context) equals(Success(BoolTy))) &&
          (t2 equals(t3)) then
          return t2
        return Failure(expr, context)
        
      case Let(variable, varValue, inExpr) =>
        if context.typeForVar(variable) != None then
          return Failure(expr, context)
        var newCxt : Context = null
        SimpleTypeChecker.checkType(varValue, context) match {
          case Success(BoolTy) =>
            newCxt = context.withVar(variable, BoolTy)
          case Success(NumTy) =>
            newCxt = context.withVar(variable, NumTy)
          case _ =>
            return Failure(expr, context)
        }
        return SimpleTypeChecker.checkType(inExpr, newCxt)
        }
    }
  }
