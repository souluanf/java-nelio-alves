package application;

import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        String strPath = "C:\\temp\\input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
            String line = br.readLine();
            while (line != null) {
                String[] item = line.split(",");
                String name = item[0];
                double price = Double.parseDouble(item[1]);
                int quantity = Integer.parseInt(item[2]);
                products.add(new Product(name, price, quantity));
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\temp\\output.txt"))) {
            for (Product product : products) {
                bw.write(String.format("%s,%.2f", product.getName(), product.calcPrice()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
