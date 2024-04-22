package org.example;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws Exception {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        System.out.println(main.calc(expression));
    }
}
