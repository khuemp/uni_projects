package tinycc.tests;

import org.junit.Test;
import prog2.tests.CompilerTests;

public class MyTests extends CompilerTests {
	@Test
	public void testCharSimple() {
		ASTMaker m = new ASTMaker("a");
		assertEqualsNormalized("'a'", (m.createCharacter("a")).toString());
	}

}
