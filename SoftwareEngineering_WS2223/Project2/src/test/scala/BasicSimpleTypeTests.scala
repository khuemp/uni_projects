package de.uni_saarland.cs.se

import Constant.*
import Expression.{*, given}
import Type.*

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BasicSimpleTypeTests extends AnyFlatSpec with Matchers {
  "The expression 'Const(True)'" should "have the type 'BoolTy'" in {
    val testExpr: Expression = Const(True)
    val t                    = SimpleTypeChecker.checkType(testExpr)
    t should equal(Success(BoolTy))
  }

  "The expression 'Const(False)'" should "have the type 'BoolTy'" in {
    val testExpr: Expression = Const(False)
    val t                    = SimpleTypeChecker.checkType(testExpr)
    t should equal(Success(BoolTy))
  }

  "The expression 'Const(Num(42))'" should "have the type 'NumTy'" in {
    val testExpr: Expression = Const(Num(42))
    val t                    = SimpleTypeChecker.checkType(testExpr)
    t should equal(Success(NumTy))
  }

  "The variable in 'x'" must "be in the context" in {
    val testExpr: Expression = Id("x")
    val error                = SimpleTypeChecker.checkType(testExpr)
    error should equal(Failure(testExpr, TypeContext()))
  }

  "The arguments to 'Smaller'" must "have the type 'Num'" in {
    val testExpr: Expression = 5 _lt False
    val error                = SimpleTypeChecker.checkType(testExpr)
    error should equal(Failure(testExpr, TypeContext()))
  }

  "The condition in 'If'" must "have the type 'BoolTy'" in {
    val testExpr: Expression = _if(3) _then True _else False
    val error                = SimpleTypeChecker.checkType(testExpr)
    error should equal(Failure(testExpr, TypeContext()))
  }

  "The 'Id' in 'Let'" must "not be in the context already" in {
    val testExpr: Expression = _let("x") _is 5 _in ("x" _lt 4)
    val context              = TypeContext[Identifier, Type](("x", NumTy))
    val error                = SimpleTypeChecker.checkType(testExpr, context)
    error should equal(Failure(testExpr, context))
  }

  "All language features" should "be implemented" in {
    val testExpr: Expression =
      _let("x") _is 5 _in (_if(True) _then 1 _else "x")
    val t = SimpleTypeChecker.checkType(testExpr)
    t should equal(Success(NumTy))
  }
}
