package application;

import entities.Product;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of products: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Common, used or imported (c/u/i)?");
            char type = scanner.next().charAt(0);
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print(name);
            System.out.print("Price: ");
            Double price = scanner.nextDouble();
            System.out.print(price);
            if (type == 'c') {

            }
        }


        scanner.close();
    }
}
