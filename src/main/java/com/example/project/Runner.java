package com.example.project;
import java.util.Scanner;
public class Runner {
    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) {
        int input = 0;
        Scanner sc = new Scanner(System.in);
        while (input != -1) {
            clear();
            System.out.print("Enter Choice: ");
            input = sc.nextInt();
            sc.nextLine();
            System.out.println("Selected Choice " + input);
        }
        sc.close();
    }
}