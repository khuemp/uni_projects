package ttfe;

import java.util.Random;

public class Simulator implements SimulatorInterface {
    private int boardHeight;
    private int boardWidth;
    private Random random;
    private int numMoves = 0;
    private int points = 0;
    private int[][] board;
    private int[][] matrix;
    private int matrixHeight;
    private int matrixWidth;

    // DONE
    public Simulator(int width, int height, Random r) throws IllegalArgumentException {
        if (height < 2 || width < 2) {
            throw new IllegalArgumentException("The height and width of the game board must be at least 2");
        }
        if (r == null) {
            throw new IllegalArgumentException("The random number generator can not be null");
        }
        this.boardHeight = height;
        this.boardWidth = width;
        this.random = r;
        this.board = new int[height][width];
        this.addPiece();
        this.addPiece();
    }

    // DONE
    public void addPiece() throws IllegalStateException {
        if (!this.isSpaceLeft()) {
            throw new IllegalStateException("The game board is already full");
        }
        int x;
        int y;
        do {
            int r = random.nextInt(boardHeight * boardWidth);
            y = r / boardWidth;
            x = r % boardWidth;
        } while (this.getPieceAt(x, y) != 0);
        if (random.nextInt(100) < 90) {
            setPieceAt(x, y, 2);
        } else {
            setPieceAt(x, y, 4);
        }
    }

    // DONE
    public int getBoardHeight() {
        return this.boardHeight;
    }

    // DONE
    public int getBoardWidth() {
        return this.boardWidth;
    }

    // DONE
    public int getNumMoves() {
        return this.numMoves;
    }

    // DONE
    public int getNumPieces() {
        int count = 0;
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                if (board[i][j] != 0) {
                    count += 1;
                }
            }
        }
        return count;
    }

    // DONE
    public int getPieceAt(int x, int y) throws IllegalArgumentException {
        if (x < 0 || x >= boardWidth || y < 0 || y >= boardHeight) {
            throw new IllegalArgumentException("Cannot get piece outside the game board");
        }
        return board[y][x];
    }

    // DONE
    public int getPoints() {
        return this.points;
    }

    // DONE
    public boolean isMovePossible() {
        return this.isMovePossible(MoveDirection.SOUTH) || this.isMovePossible(MoveDirection.NORTH)
                || this.isMovePossible(MoveDirection.EAST) || this.isMovePossible(MoveDirection.WEST);
    }

    // DONE
    public boolean isMovePossible(MoveDirection direction) throws IllegalArgumentException {
        if (direction == null) {
            throw new IllegalArgumentException("The direction cannot be null");
        }
        // move left -> right, array starts from left; analogous for right, up, down

        if (direction == MoveDirection.EAST) {
            matrixHeight = boardHeight;
            matrixWidth = boardWidth;
            matrix = new int[matrixHeight][matrixWidth];
            for (int i = 0; i < boardHeight; i++) {
                for (int j = 0; j < boardWidth; j++) {
                    matrix[i][j] = board[i][j];
                }
            }
        }
        if (direction == MoveDirection.WEST) {
            matrixHeight = boardHeight;
            matrixWidth = boardWidth;
            matrix = new int[matrixHeight][matrixWidth];
            for (int i = 0; i < boardHeight; i++) {
                for (int j = 0; j < boardWidth; j++) {
                    matrix[i][j] = board[i][boardWidth - 1 - j];
                }
            }
        }
        if (direction == MoveDirection.SOUTH) {
            matrixHeight = boardWidth;
            matrixWidth = boardHeight;
            matrix = new int[matrixHeight][matrixWidth];
            for (int i = 0; i < boardWidth; i++) {
                for (int j = 0; j < boardHeight; j++) {
                    matrix[i][j] = board[j][i];
                }
            }
        }
        if (direction == MoveDirection.NORTH) {
            matrixHeight = boardWidth;
            matrixWidth = boardHeight;
            matrix = new int[matrixHeight][matrixWidth];
            for (int i = 0; i < boardWidth; i++) {
                for (int j = 0; j < boardHeight; j++) {
                    matrix[i][j] = board[boardHeight - 1 - j][i];
                }
            }
        }

        for (int i = 0; i < matrixHeight; i++) {
            if (possibeRowMove(matrix[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean possibeRowMove(int[] row) {
        int firstPos = 0;
        int lastPos = matrixWidth - 1;

        int numNonZero = 0;

        while (lastPos >= 0 && row[lastPos] == 0) {
            lastPos -= 1;
        }

        while (firstPos < matrixWidth && row[firstPos] == 0) {
            firstPos += 1;
        }

        for (int i = 0; i < matrixWidth; i++) {
            if (row[i] != 0) {
                numNonZero += 1;
            }
        }

        // empty row
        if (numNonZero == 0) {
            return false;
        }

        if (lastPos == matrixWidth - 1 && lastPos - firstPos == numNonZero - 1) {
            boolean hasDuplicate = false;
            for (int i = firstPos; i <= lastPos - 1; i++) {
                if (row[i] == row[i + 1]) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (!hasDuplicate) {
                return false;
            }
        }
        return true;
    }

    // DONE
    public boolean isSpaceLeft() {
        return this.getNumPieces() < this.boardHeight * this.boardWidth;
    }

    // DONE
    public boolean performMove(MoveDirection direction) throws IllegalArgumentException {
        if (direction == null) {
            throw new IllegalArgumentException("The direction cannot be null");
        }

        if (!isMovePossible(direction)) {
            return false;
        }

        int[][] saveMatrix = new int[matrixHeight][matrixWidth];
        for (int i = 0; i < matrixHeight; i++) {
            int xSave = matrixWidth - 1;
            int x = matrixWidth - 1;
            while (x >= 0) {
                if (matrix[i][x] == 0) {
                    x -= 1;
                    continue;
                }
                int xNext = x - 1;
                while (xNext >= 0 && matrix[i][xNext] == 0) {
                    xNext -= 1;
                }

                int xNew;
                int saveValue = matrix[i][x];
                if (xNext < 0) {
                    xNew = -1;
                } else {
                    if (matrix[i][xNext] == matrix[i][x]) {
                        saveValue = 2 * matrix[i][x];
                        points += saveValue;
                        xNew = xNext - 1;
                    } else {
                        xNew = xNext;
                    }
                }

                saveMatrix[i][xSave] = saveValue;
                xSave -= 1;
                x = xNew;
            }
        }

        if (direction == MoveDirection.EAST) {
            for (int i = 0; i < boardHeight; i++) {
                for (int j = 0; j < boardWidth; j++) {
                    setPieceAt(j, i, saveMatrix[i][j]);
                }
            }
        }

        if (direction == MoveDirection.WEST) {
            for (int i = 0; i < boardHeight; i++) {
                for (int j = 0; j < boardWidth; j++) {
                    setPieceAt(j, i, saveMatrix[i][boardWidth - 1 - j]);
                }
            }
        }

        if (direction == MoveDirection.SOUTH) {
            for (int i = 0; i < boardHeight; i++) {
                for (int j = 0; j < boardWidth; j++) {
                    setPieceAt(j, i, saveMatrix[j][i]);
                }
            }
        }

        if (direction == MoveDirection.NORTH) {
            for (int i = 0; i < boardHeight; i++) {
                for (int j = 0; j < boardWidth; j++) {
                    setPieceAt(j, i, saveMatrix[j][boardHeight - 1 - i]);
                }
            }
        }

        numMoves += 1;
        return true;
    }

    // DONE
    public void run(PlayerInterface player, UserInterface ui) throws IllegalArgumentException {
        if (player == null) {
            throw new IllegalArgumentException("The player cannot be null");
        }
        if (ui == null) {
            throw new IllegalArgumentException("The ui cannot be null");
        }

        // printBoard();
        ui.updateScreen(this);

        while (isMovePossible()) {
            MoveDirection direction = player.getPlayerMove(this, ui);
            // System.out.println(direction);
            if (performMove(direction)) {
                // ui.updateScreen(this);
                // try {
                // Thread.sleep(500);
                // } catch (InterruptedException e) {
                // e.printStackTrace();
                // }
                addPiece();
                ui.updateScreen(this);
                // printBoard();
            } else {
                ui.showMessage("Can not move " + direction + "!");
            }
        }
        ui.showGameOverScreen(this);
    }

    // private void printBoard() {
    //     for (int i = 0; i < this.boardHeight; i++) {
    //         for (int j = 0; j < this.boardWidth; j++) {
    //             System.out.print(this.board[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    //     System.out.println();
    // }

    // DONE
    public void setPieceAt(int x, int y, int piece) throws IllegalArgumentException {
        if (x < 0 || x >= boardWidth || y < 0 || y >= boardHeight) {
            throw new IllegalArgumentException("Cannot set piece outside the game board");
        }
        if (piece < 0) {
            throw new IllegalArgumentException("The piece value must be positive");
        }
        board[y][x] = piece;
    }
}
