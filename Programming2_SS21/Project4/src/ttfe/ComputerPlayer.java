package ttfe;

public class ComputerPlayer implements PlayerInterface {
    private boolean mustReturnWest = false;
    private boolean mustReturnSouth = false;

    public ComputerPlayer() {
    }

    @Override
    public MoveDirection getPlayerMove(SimulatorInterface game, UserInterface ui) {

        MoveDirection[] directionsNormal = { MoveDirection.WEST, MoveDirection.SOUTH };
        MoveDirection moveNormal = getDirectionMaxPoint(game, directionsNormal);

        if (mustReturnSouth) {
            if(game.isMovePossible(MoveDirection.SOUTH)){
                return MoveDirection.SOUTH;
            }
            mustReturnWest = false;
        }

        if (mustReturnWest) {
            if(game.isMovePossible(MoveDirection.WEST)){
                return MoveDirection.WEST;
            }
            mustReturnWest = false;
        }

        if (moveNormal == null) {
            if (!game.isMovePossible(MoveDirection.EAST)) {
                mustReturnSouth = true;
                return MoveDirection.NORTH;
            }
            mustReturnWest = true;
            return MoveDirection.EAST;
        }
        return moveNormal;
    }

    private MoveDirection getDirectionMaxPoint(SimulatorInterface game, MoveDirection[] directionWanted) {
        int maxPoint = -1;
        MoveDirection maxDir = MoveDirection.EAST;
        for (MoveDirection dir : directionWanted) {
            int gained = pointGained(dir, game);
            if (maxPoint < gained) {
                maxPoint = gained;
                maxDir = dir;
            }
        }

        if (maxPoint < 0) {
            return null;
        }

        return maxDir;
    }

    private int pointGained(MoveDirection direction, SimulatorInterface game) {
        if (!game.isMovePossible(direction)) {
            return -1;
        }

        int[][] matrix;
        int matrixHeight;
        int matrixWidth;

        if (direction == MoveDirection.EAST) {
            matrixHeight = game.getBoardHeight();
            matrixWidth = game.getBoardWidth();
            matrix = new int[matrixHeight][matrixWidth];
            for (int i = 0; i < game.getBoardHeight(); i++) {
                for (int j = 0; j < game.getBoardWidth(); j++) {
                    matrix[i][j] = game.getPieceAt(j, i);
                }
            }
        } else if (direction == MoveDirection.WEST) {
            matrixHeight = game.getBoardHeight();
            matrixWidth = game.getBoardWidth();
            matrix = new int[matrixHeight][matrixWidth];
            for (int i = 0; i < game.getBoardHeight(); i++) {
                for (int j = 0; j < game.getBoardWidth(); j++) {
                    matrix[i][j] = game.getPieceAt(game.getBoardWidth() - 1 - j, i);
                }
            }
        } else if (direction == MoveDirection.SOUTH) {
            matrixHeight = game.getBoardWidth();
            matrixWidth = game.getBoardHeight();
            matrix = new int[matrixHeight][matrixWidth];
            for (int i = 0; i < game.getBoardWidth(); i++) {
                for (int j = 0; j < game.getBoardHeight(); j++) {
                    matrix[i][j] = game.getPieceAt(i, j);
                }
            }
        } else { // NORTH
            matrixHeight = game.getBoardWidth();
            matrixWidth = game.getBoardHeight();
            matrix = new int[matrixHeight][matrixWidth];
            for (int i = 0; i < game.getBoardWidth(); i++) {
                for (int j = 0; j < game.getBoardHeight(); j++) {
                    matrix[i][j] = game.getPieceAt(i, game.getBoardHeight() - 1 - j);
                }
            }
        }

        int point = 0;
        for (int i = 0; i < matrixHeight; i++) {
            point += pointGainedRow(matrix[i]);
        }

        return point;

    }

    private int pointGainedRow(int[] row) {
        int point = 0;
        int x = row.length - 1;
        while (x >= 0) {
            if (row[x] == 0) {
                x -= 1;
                continue;
            }
            int xNext = x - 1;
            while (xNext >= 0 && row[xNext] == 0) {
                xNext -= 1;
            }

            int xNew;
            int saveValue = row[x];
            if (xNext < 0) {
                xNew = -1;
            } else {
                if (row[xNext] == row[x]) {
                    saveValue = 2 * row[x];
                    point += saveValue;
                    xNew = xNext - 1;
                } else {
                    xNew = xNext;
                }
            }
            x = xNew;
        }
        return point;
    }
}
