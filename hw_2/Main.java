
//Данная программа написана в процедурной и структурной парадигме,
//так для вызова метода используется отдельный класс,
//и не используется goto

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    private static PrintStream out = new PrintStream(System.out);
    private static PrintStream err = new PrintStream(System.err);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            out.println("Введите число n: ");
            task.multiplicationTable(sc.nextInt());
        } catch (Exception e) {
            err.println("Неверный ввод ");
        }

    }
}

