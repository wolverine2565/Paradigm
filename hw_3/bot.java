import java.util.Objects;
import java.util.Random;

public class bot {
    private static Random random = new Random ();
    public static int[] getRandomEmptyCell(String[][] board) {
        do {
            int R = random.nextInt(Main.ROW_COUNT);
            int C = random.nextInt(Main.COL_COUNT);

            if (Objects.equals(board[R][C], Main.CELL_STATE_EMPTY)){
                return new int[]{R,C};
            }

        } while (true);
    }

    public static void makeBotTurn (String[][] board) {
        System.out.println("Ход бота ");

        int[] coordinates = getRandomEmptyCell(board);
        board[coordinates[0]][coordinates[1]] = Main.CELL_STATE_O;
    }
}
//