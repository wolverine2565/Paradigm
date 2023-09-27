public class task {
    public static void multiplicationTable(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(j + " x " + i + " = " + (i * j) + "\t");
            }
        }
    }
}