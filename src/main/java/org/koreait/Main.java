package org.koreait;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        new App().run(scanner);

        scanner.close();
    }
}