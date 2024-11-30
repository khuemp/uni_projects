package de.uni_saarland.cs.se

import Constant.*
import Type.*
import VExpression.{*, given}
import VariabilityContext.given

import cafesat.api.{FormulaBuilder, Formulas}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BasicVariabilityTypeTests extends AnyFlatSpec with Matchers {
  "The expression 'Const(True)'" should "have the type 'BoolTy'" in {
    val testExpr: VExpression = Const(True)
    val t                     = VariabilityTypeChecker.checkType(testExpr)
    t should equal(Success(VType(BoolTy -> Formulas.True)))
  }

  "The expression 'Const(False)'" should "have the type 'BoolTy'" in {
    val testExpr: VExpression = Const(False)
    val t                     = VariabilityTypeChecker.checkType(testExpr)
    t should equal(Success(VType(BoolTy -> Formulas.True)))
  }

  "The expression 'Const(Num(42))'" should "have the type 'NumTy'" in {
    val testExpr: VExpression = Const(Num(42))
    val t                     = VariabilityTypeChecker.checkType(testExpr)
    t should equal(Success(VType(NumTy -> Formulas.True)))
  }

  "The variable in 'x'" must "be in the context" in {
    val testExpr: VExpression = Id("x")
    val error                 = VariabilityTypeChecker.checkType(testExpr)
    error should equal(
      Failure(testExpr, VariabilityTypeChecker.createContext())
    )
  }

  "The arguments to 'Smaller'" must "have the type 'Num'" in {
    val testExpr: VExpression = 5 _lt False
    val error                 = VariabilityTypeChecker.checkType(testExpr)
    error should equal(
      Failure(testExpr, VariabilityTypeChecker.createContext())
    )
  }

  "The condition in 'If'" must "have the type 'BoolTy'" in {
    val testExpr: VExpression = _if(3) _then True _else False
    val error                 = VariabilityTypeChecker.checkType(testExpr)
    error should equal(
      Failure(testExpr, VariabilityTypeChecker.createContext())
    )
  }

  "The 'Id' in 'Let'" must "not be in the context already" in {
    val testExpr: VExpression = _let("x") _is 5 _in ("x" _lt 4)
    val context = VariabilityTypeChecker.createContext(
      typeContext = TypeContext(("x", VType(NumTy -> Formulas.True)))
    )
    val error = VariabilityTypeChecker.checkType(testExpr, context)
    error should equal(Failure(testExpr, context))
  }

  "The expression 'Choice(A || B, True, 5)'" should "have a VType with two entries" in {
    val A                     = FormulaBuilder.propVar("A")
    val B                     = FormulaBuilder.propVar("B")
    val testExpr: VExpression = Choice(A || B, True, 5)
    val t                     = VariabilityTypeChecker.checkType(testExpr)
    t should equal(Success(VType(BoolTy -> (A || B), NumTy -> !(A || B))))
  }
}
