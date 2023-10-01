import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static final int ROW_COUNT = 3;
    public static final int COL_COUNT = 3;
    public static final String CELL_STATE_EMPTY = " ";
    public static final String CELL_STATE_O = "O";
    public static final String CELL_STATE_X = "X";
    public static final String GAME_STATE_X_WON = "Х победили!";
    public static final String GAME_STATE_O_WON = "O победили!";
    public static final String GAME_STATE_DRAW = "Ничья";
    public static final String GAME_STATE_NOT_FINISHED = "Игра не закончена";


    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        startRound();
    }

    public static void startRound() {
        String[][] board = createboard();
        startLoop(board);


    }

    public static String[][] createboard() {
        String[][] board = new String[ROW_COUNT][COL_COUNT];
        for (int R = 0; R < ROW_COUNT; R++) {
            for (int C = 0; C < COL_COUNT; C++) {
                board[R][C] = CELL_STATE_EMPTY;
            }
        }
        return board;
    }

    public static void startLoop(String[][] board) {
        boolean playerTurn = true;

        do {
            if (playerTurn) {
                makePlayer1Turn(board);
                printboard(board);
            } else {
                makePlayer2Turn(board);
                printboard(board);
            }

            playerTurn = !playerTurn;

            System.out.println();

            String gameState = checkGameState(board);
            if (!Objects.equals(gameState, GAME_STATE_NOT_FINISHED)) {
                System.out.println(gameState);
                return;
            }
        } while (true);
    }

    public static int[] inpitCelldCordinates(String[][] board) {

        System.out.println("Введите координаты ячейки через пробел(0-2) ");

        do {
            String[] userInput = sc.nextLine().split(" ");
            int R = Integer.parseInt(userInput[0]);
            int C = Integer.parseInt(userInput[1]);

            if (R < 0 || R >= ROW_COUNT || C < 0 || C >= COL_COUNT) {
                System.out.println("Неверный ввод. Значения чисел должн быть от 0 до 2 ");
            } else if (!Objects.equals(board[R][C], CELL_STATE_EMPTY)) {
                System.out.println("Данная ячейка уже занята ");
            } else {
                return new int[]{R, C};
            }
        } while (true);
    }

    public static void makePlayer1Turn(String[][] board) {
        int[] coordinates = inpitCelldCordinates(board);
        board[coordinates[0]][coordinates[1]] = CELL_STATE_X;
    }

    public static void makePlayer2Turn(String[][] board) {
        int[] coordinates = inpitCelldCordinates(board);
        board[coordinates[0]][coordinates[1]] = CELL_STATE_O;
    }

    public static void printboard(String[][] board) {
        System.out.println("_________");

        for (int R = 0; R < ROW_COUNT; R++) {
            String line = "| ";
            for (int C = 0; C < COL_COUNT; C++) {
                line += board[R][C] + " ";
            }
            line += "|";

            System.out.println(line);
        }
        System.out.println("_________");
    }

    public static String checkGameState(String[][] board) {
        ArrayList<Integer> sums = new ArrayList<>();
        for (int R = 0; R < ROW_COUNT; R ++){
            int rowSum = 0;
            for (int C = 0; C < COL_COUNT; C++){
                rowSum += calculateNumValue(board[R][C]);
            }
            sums.add(rowSum);
        }
        for (int col = 0; col < COL_COUNT; col++) {
            int colSum = 0;
            for (int row = 0; row < ROW_COUNT; row++) {
                colSum += calculateNumValue(board[row][col]);
            }
            sums.add(colSum);
        }

        int leftDiagonalSum = 0;
        for (int i = 0; i < ROW_COUNT; i++) {
            leftDiagonalSum += calculateNumValue(board[i][i]);
        }
        sums.add(leftDiagonalSum);

        int rightDiagonalSum = 0;
        for (int i = 0; i < ROW_COUNT; i++) {
            rightDiagonalSum += calculateNumValue(board[i][(ROW_COUNT - 1) - i]);
        }
        sums.add(rightDiagonalSum);

        if (sums.contains(3)) {
            return GAME_STATE_O_WON;
        } else if (sums.contains(-3)) {
            return GAME_STATE_X_WON;
        } else if (allCellsTaken(board)) {
            return GAME_STATE_DRAW;
        } else {
            return GAME_STATE_NOT_FINISHED;
        }
    }


    public static int calculateNumValue (String cellstate){
        if (cellstate == CELL_STATE_X) {
            return -1;
        } else {
            return 0;
        }
    }

    public static boolean allCellsTaken(String[][] board) {
        for (int R = 0; R < ROW_COUNT; R++) {
            for (int C = 0; C < COL_COUNT; C++) {
                if (board[R][C] != CELL_STATE_EMPTY) {
                    return false;

                }
            }
        }
        return true;
    }
}


