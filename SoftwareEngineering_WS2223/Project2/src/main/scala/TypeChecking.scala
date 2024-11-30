/** Some generic classes that are used by both, the simple type checker and the
  * variability-aware type checker.
  */
package de.uni_saarland.cs.se

import Constant.*
import Expression.*
import Type.*

import cafesat.api.Formulas.Formula
import cafesat.api.{Formulas, Solver}

/** The result returned by the type checker.
  *
  * A result can be either a `Success` or a `Failure`. A `Success` object
  * contains the inferred type and a `Failure` object contains information about
  * the type error.
  *
  * This class implements the monad functions, so it can be used in
  * for-comprehensions:
  *
  * for {
  *   t1 <- checkA(...)
  *   t2 <- checkB(...)
  * } yield { t2 }
  *
  * @tparam ExpressionT
  *   the expressions of the language
  * @tparam TypeT
  *   the types of the language
  * @tparam ContextT
  *   the context used during type checking, i.e., type context and optionally
  *   variability context
  */
sealed abstract class TypeCheckResult[ExpressionT, TypeT, ContextT] {
  def pure(t: TypeT): TypeCheckResult[ExpressionT, TypeT, ContextT] = Success(t)

  def flatMap(
      fn: TypeT => TypeCheckResult[ExpressionT, TypeT, ContextT]
  ): TypeCheckResult[ExpressionT, TypeT, ContextT] = this match {
    case Success(vtype)                           => fn(vtype)
    case f: Failure[ExpressionT, TypeT, ContextT] => f
  }

  def map(
      fn: TypeT => TypeT
  ): TypeCheckResult[ExpressionT, TypeT, ContextT] = flatMap(fn.andThen(pure))
}

/** Indicates a successful type check.
  *
  * @param t
  *   the type inferred during type checking
  */
case class Success[ExpressionT, TypeT, ContextT](t: TypeT)
    extends TypeCheckResult[ExpressionT, TypeT, ContextT]

/** Indicates a type error.
  *
  * @param expr
  *   the (sub) expression that is currently checked
  * @param context
  *   the current context
  * @param message
  *   a message describing the type error
  */
case class Failure[ExpressionT, TypeT, ContextT](
    expr: ExpressionT,
    context: ContextT,
    message: String = ""
) extends TypeCheckResult[ExpressionT, TypeT, ContextT] {
  override def toString: String = {
    s"Error @ $expr\n" +
      (message match {
        case "" => ""
        case m  => s"  Message: $m\n"
      }) +
      s"  Context: $context"
  }

  /** Ignore the message in equality checks.
    */
  override def equals(obj: Any): Boolean = {
    obj match {
      case errorB: Failure[_, _, _] =>
        expr == errorB.expr && context == errorB.context
      case _ => false
    }
  }
}

/** The type checker interface.
  *
  * @tparam ExpressionT
  *   the expressions of the language
  * @tparam TypeT
  *   the types of the language
  * @tparam ContextT
  *   the context used during type checking, i.e., type context and optionally
  *   variability context
  */
trait TypeChecker[ExpressionT, TypeT, ContextT] {

  /** Determine the type of an expression given some context.
    *
    * @param expr
    *   the expression to type-check
    * @param context
    *   the context used for type checking
    */
  def checkType(
      expr: ExpressionT,
      context: ContextT
  ): TypeCheckResult[ExpressionT, TypeT, ContextT]
}
