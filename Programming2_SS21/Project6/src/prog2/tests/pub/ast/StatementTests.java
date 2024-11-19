package prog2.tests.pub.ast;

import org.junit.Test;

import tinycc.implementation.expression.Expression;
import tinycc.implementation.statement.Statement;
import prog2.tests.ASTExercise;
import prog2.tests.CompilerTests;
import prog2.tests.PublicTest;

public class StatementTests extends CompilerTests implements PublicTest, ASTExercise {
	@Test
	public void testBlockEmpty() {
		final ASTMaker m = new ASTMaker("testEmptyBlock");
		final Statement s = m.createBlock();
		assertEqualsNormalized("{}", s.toString());
	}

	@Test
	public void testEmpty() {
		final ASTMaker m = new ASTMaker("testEmpty");
		final Statement s = m.createEmpty();
		assertEqualsNormalized(";", s.toString());
	}

	@Test
	public void testExpressionStmt() {
		final ASTMaker m = new ASTMaker("testExpressionStatement");
		final Expression e = m.createNumber("42");
		final Statement s = m.createExpressionStatement(e);
		assertEqualsNormalized("42;", s.toString());
	}

	@Test
	public void testIfThen() {
		final ASTMaker m = new ASTMaker("testIfThen");
		final Expression cond = m.createNumber("1");
		final Statement con = m.createBlock();
		final Statement iff = m.createIf(cond, con, null);
		assertEqualsNormalized("if(1){}", iff.toString());
	}

	@Test
	public void testIfThenElse() {
		final ASTMaker m = new ASTMaker("testIfThenElse");
		final Expression cond = m.createNumber("1");
		final Statement con = m.createBlock();
		final Statement alt = m.createBlock();
		final Statement iff = m.createIf(cond, con, alt);
		assertEqualsNormalized("if(1){}else{}", iff.toString());
	}

	@Test
	public void testReturnVoid() {
		final ASTMaker m = new ASTMaker("testReturnVoid");
		final Statement s = m.createReturn(null);
		assertEqualsNormalized("return;", s.toString());
	}

	@Test
	public void testReturnValue() {
		final ASTMaker m = new ASTMaker("testReturnValue");
		final Expression e = m.createNumber("42");
		final Statement s = m.createReturn(e);
		assertEqualsNormalized("return42;", s.toString());
	}

	@Test
	public void testWhile() {
		final ASTMaker m = new ASTMaker("testWhile");
		final Expression cond = m.createNumber("1");
		final Statement body = m.createBlock();
		final Statement s = m.createWhile(cond, body);
		assertEqualsNormalized("while(1){}", s.toString());
	}

	@Test
	public void testBlockNonEmpty() {
		final ASTMaker m = new ASTMaker("testBlockWithEmptyStatement");
		final Statement e = m.createEmpty();
		final Statement s = m.createBlock(e);
		assertEqualsNormalized("{;}", s.toString());
	}
}
