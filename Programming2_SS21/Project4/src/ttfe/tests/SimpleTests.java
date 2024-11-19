package ttfe.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import ttfe.MoveDirection;
import ttfe.SimulatorInterface;
import ttfe.TTFEFactory;

/**
 * This class provides a very simple example of how to write tests for this
 * project. You can implement your own tests within this class or any other
 * class within this package. Tests in other packages will not be run and
 * considered for completion of the project.
 */
public class SimpleTests {

	private SimulatorInterface game;

	@Before
	public void setUp() {
		game = TTFEFactory.createSimulator(4, 4, new Random(0));
	}

	// initial tests
	@Test
	public void testInitialGamePoints() {
		assertEquals("The initial game did not have zero points", 0, game.getPoints());
	}

	@Test
	public void testInitialBoardHeight() {
		assertTrue("The initial game board did not have correct height", 4 == game.getBoardHeight());
	}

	@Test
	public void testInitialBoardWidth() {
		assertTrue("The initial game board did not have correct width", 4 == game.getBoardWidth());
	}

	@Test
	public void testInitialNumPieces() {
		assertEquals("The initial game board did not have correct number of pieces", 2, game.getNumPieces());
	}

	@Test
	public void testInitialNumMoves() {
		assertEquals("The initial game board did not have correct number of moves", 0, game.getNumMoves());
	}

	@Test
	public void testInitialSpaceLeft() {
		assertTrue("The initial game board did not have correct number of spaces left", game.isSpaceLeft());
	}

	// test addPiece
	@Test
	public void testAddPieceAppear() {
		game.addPiece();
		game.addPiece();
		int pieces = 0;
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				if (game.getPieceAt(j, i) != 0) {
					pieces++;
				}
			}
		}
		assertEquals("The game board added pieces failed", 4, pieces);
	}

	@Test
	public void testAddPieceFullBoard1() {
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				game.setPieceAt(j, i, 8);
				;
			}
		}
		game.setPieceAt(0, 0, 0);
		game.addPiece();
		assertTrue("The game board added wrong piece", game.getPieceAt(0, 0) == 2 || game.getPieceAt(0, 0) == 4);
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 1; j < game.getBoardWidth(); j++) {
				assertTrue("The game board added piece at the wrong square", game.getPieceAt(j, i) == 8);
			}
		}
		for (int i = 1; i < game.getBoardHeight(); i++) {
			assertTrue("The game board added piece at the wrong square", game.getPieceAt(0, i) == 8);
		}
		assertTrue("The game board should be full after adding piece", !game.isSpaceLeft());
	}

	@Test
	public void testAddPieceFullBoard2() {
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				game.setPieceAt(j, i, 0);
				;
			}
		}
		for (int i = 0; i < game.getBoardHeight() * game.getBoardWidth(); i++) {
			game.addPiece();
		}
		assertEquals("The game board should have 16 pieces", game.getBoardWidth() * game.getBoardHeight(),
				game.getNumPieces());
		assertTrue("The game board should be full after adding piece", !game.isSpaceLeft());
	}

	// test getNumMoves
	@Test
	public void testGetNumMovesFailed() {
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				game.setPieceAt(j, i, 0);
			}
		}
		game.setPieceAt(0, 0, 2);
		game.setPieceAt(0, 1, 2);
		game.performMove(MoveDirection.WEST);
		assertEquals("The game board had the wrong number of moves", 0, game.getNumMoves());
	}

	@Test
	public void testGetNumMovesSuccess() {
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				game.setPieceAt(j, i, 0);
			}
		}
		game.setPieceAt(0, 0, 2);
		game.setPieceAt(0, 1, 2);
		game.performMove(MoveDirection.NORTH);
		assertEquals("The game board had the wrong number of moves", 1, game.getNumMoves());
	}

	// test getNumPieces
	@Test
	public void testGetNumPiecesAdd() {
		game.addPiece();
		assertEquals("The game board had the wrong number of pieces after adding new piece", 3, game.getNumPieces());
	}

	@Test
	public void testGetNumPiecesMerge() {
		game.performMove(MoveDirection.SOUTH);
		game.performMove(MoveDirection.EAST);
		assertEquals("The game board had wrong number of pieces after merging", 1, game.getNumPieces());
	}

	@Test
	public void testGetNumPiecesUnchaged() {
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				game.setPieceAt(j, i, 0);
			}
		}
		game.setPieceAt(0, 0, 2);
		game.setPieceAt(0, 1, 2);
		game.performMove(MoveDirection.WEST);
		assertEquals("The game board had wrong number of pieces", 2, game.getNumPieces());
	}

	// test getPoints
	@Test
	public void testGetPointsMerge() {
		int beforeMergePoints = game.getPoints();
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				game.setPieceAt(j, i, 0);
			}
		}
		game.setPieceAt(0, 0, 2);
		game.setPieceAt(0, 1, 2);
		game.performMove(MoveDirection.SOUTH);
		int afterMergePoints = game.getPoints();
		assertTrue("The game board added wrong points", beforeMergePoints + 4 == afterMergePoints);
	}

	@Test
	public void testGetPointsUnchaged1() {
		int beforeUnchanged1Points = game.getPoints();
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				game.setPieceAt(j, i, 0);
			}
		}
		game.setPieceAt(0, 0, 2);
		game.setPieceAt(0, 1, 2);
		game.performMove(MoveDirection.WEST);
		int afterUnchanged1Points = game.getPoints();
		assertTrue("The game board after moving had wrong unchanged points",
				beforeUnchanged1Points == afterUnchanged1Points);
	}

	@Test
	public void testGetPointsUnchaged2() {
		int beforeUnchanged2Points = game.getPoints();
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				game.setPieceAt(j, i, 0);
			}
		}
		game.setPieceAt(0, 0, 2);
		game.setPieceAt(0, 1, 2);
		game.performMove(MoveDirection.EAST);
		int afterUnchanged2Points = game.getPoints();
		assertTrue("The game board after unmoving had wrong unchanged points",
				beforeUnchanged2Points == afterUnchanged2Points);
	}

	// test getPieceAt
	@Test
	public void testGetPieceAt2() {
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				game.setPieceAt(j, i, 0);
			}
		}
		game.setPieceAt(0, 0, 2);
		assertEquals("The game board implemented wrong get piece", 2, game.getPieceAt(0, 0));
	}

	@Test
	public void testGetPieceAt0() {
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				game.setPieceAt(j, i, 0);
				assertEquals("The game board implemented wrong get piece", 0, game.getPieceAt(j, i));
			}
		}
	}

	// test setPieceAt has already been test in others tests

	// test isMovePossible
	@Test
	public void testIsMovePossible1Piece() {
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				game.setPieceAt(j, i, 0);
			}
		}
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				game.setPieceAt(j, i, 2);
				if (j == 0) {
					assertTrue("The game board had wrong possible move",
							!game.isMovePossible(MoveDirection.WEST) && game.isMovePossible(MoveDirection.EAST));
				} else if (j == 3) {
					assertTrue("The game board had wrong possible move",
							game.isMovePossible(MoveDirection.WEST) && !game.isMovePossible(MoveDirection.EAST));
				} else {
					assertTrue("The game board had wrong possible move",
							game.isMovePossible(MoveDirection.WEST) && game.isMovePossible(MoveDirection.EAST));
				}
				if (i == 0) {
					assertTrue("The game board had wrong possible move",
							!game.isMovePossible(MoveDirection.NORTH) && game.isMovePossible(MoveDirection.SOUTH));
				} else if (i == 3) {
					assertTrue("The game board had wrong possible move",
							game.isMovePossible(MoveDirection.NORTH) && !game.isMovePossible(MoveDirection.SOUTH));
				} else {
					assertTrue("The game board had wrong possible move",
							game.isMovePossible(MoveDirection.NORTH) && game.isMovePossible(MoveDirection.SOUTH));
				}
				assertTrue("The game board had wrong possible move", game.isMovePossible());
				game.setPieceAt(j, i, 0);
			}
		}
	}

	@Test
	public void testIsMovePossible2Pieces() {
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				game.setPieceAt(j, i, 0);
			}
		}
		game.setPieceAt(0, 0, 2);
		game.setPieceAt(3, 3, 2);
		assertTrue("The game board had wrong possible move with 2 pieces",
				game.isMovePossible() && game.isMovePossible(MoveDirection.EAST)
						&& game.isMovePossible(MoveDirection.WEST) && game.isMovePossible(MoveDirection.NORTH)
						&& game.isMovePossible(MoveDirection.SOUTH));
	}

	// test ifSpaceLeft
	@Test
	public void testIfSpaceLeft() {
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				if (game.getPieceAt(j, i) == 0) {
					game.setPieceAt(j, i, 2);
				}
			}
		}
		assertTrue("The game board had wrong number of spaces left", !game.isSpaceLeft());
	}

	// test performMove
	@Test
	public void testPerform4Moves() {
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				game.setPieceAt(j, i, 0);
			}
		}
		game.setPieceAt(1, 1, 2);
		boolean move1 = game.performMove(MoveDirection.WEST);
		boolean move2 = game.performMove(MoveDirection.NORTH);
		boolean move3 = game.performMove(MoveDirection.EAST);
		boolean move4 = game.performMove(MoveDirection.SOUTH);

		assertTrue("The game board performed moves failed", move1 && move2 && move3 && move4);
	}

	// test simulation
	@Test
	public void testSimulation1() {
		for (int i = 0; i < game.getBoardHeight(); i++) {
			for (int j = 0; j < game.getBoardWidth(); j++) {
				game.setPieceAt(j, i, 0);
			}
		}
		game.setPieceAt(1, 1, 2);
		game.setPieceAt(0, 2, 2);
		assertEquals("The simulation has wrong number of pieces", 2, game.getNumPieces());
		boolean move1 = game.performMove(MoveDirection.WEST);
		game.setPieceAt(2, 1, 4);
		assertEquals("The simulation has wrong number of pieces", 3, game.getNumPieces());
		boolean move2 = game.performMove(MoveDirection.SOUTH);
		boolean move3 = game.performMove(MoveDirection.EAST);
		assertTrue("The simulation had wrong isPossibleMove",
				game.isMovePossible() && !game.isMovePossible(MoveDirection.EAST)
						&& game.isMovePossible(MoveDirection.WEST) && game.isMovePossible(MoveDirection.NORTH)
						&& !game.isMovePossible(MoveDirection.SOUTH));
		boolean move4 = game.performMove(MoveDirection.EAST);
		assertEquals("The simulation had wrong number of moves", 3, game.getNumMoves());
		assertTrue("The simulation had wrong points", game.getPoints() > 0);
		assertEquals("The simulation had wrong piece", 8, game.getPieceAt(3, 3));
		assertTrue("The simulation performed wrong moves", move1 && move2 && move3 && !move4);
	}
}