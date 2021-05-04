package application;

import entitities.Employee;
import entitities.OutSourcedEmpployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<Employee> employees = new ArrayList<>();

        System.out.println("Enter the number of Employees: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + i + " data: ");
            System.out.print("Outsourced (y/n)? ");
            char ch = scanner.next().charAt(0);
            System.out.println("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.println("Hours: ");
            int hours = scanner.nextInt();
            System.out.println("Value per hour: ");
            double valuePerHour = scanner.nextDouble();
            if (ch == 'y') {
                System.out.println("Additional charge: ");
                double additionalCharge = scanner.nextDouble();
                employees.add(new OutSourcedEmpployee(name, hours, valuePerHour, additionalCharge));
            } else {
                employees.add(new Employee(name, hours, valuePerHour));
            }
        }


        System.out.println("\nPAYMENTS:");
        for (Employee emp: employees){
            System.out.println(emp.getName() + " - $"+String.format("%.2f",emp.payment()));
        }

//        System.out.println("\nPAYMENTS:");
//        employees.stream().map(emp -> emp.getName() + " - $ "+String.format("%.2f",emp.payment()))
//                .forEach(System.out::println);
//        scanner.close();

    }
}
