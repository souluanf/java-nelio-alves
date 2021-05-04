package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

    /*
     * Inversão de controle: Padrão de desenvolvimento que consiste em retirar da classe a responsabilidade
     * de instanciar suas dependencias
     *
     * Injeção de dependência:É uma forma de realizar a inversão de controle: um componente externo instancia
     * a dependência, que é então injetada no objeto "pai". Pode ser implementada de várias formas:
     *  - construtor
     *  - classe de instanciação(builder,factory)
     *  - container/ framework
     *
     *
     *  Herança -> Reuso
     * Interface -> Cumprir contrado
     */

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        System.out.println("Enter rental data");
        System.out.print("Car model: ");
        String carModel = sc.nextLine();
        System.out.print("Pickup (dd/MM/yyyy HH:mm): ");
        Date start = sdf.parse(sc.nextLine());
        System.out.print("Return (dd/MM/yyyy HH:mm): ");
        Date finish = sdf.parse(sc.nextLine());

        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Enter price per hour: ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Enter price per day: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
        /*
         * BrasilTaxService é classe concreta. Está acontecendo upcasting. Injeção de dependencia por meio de construtor
         *  um objeto de servço de imposto do qual minha classe RentalService depende é instanciado em outro lugar,
         *  neste cado pelo programa principal e essa instancia de BrasilTaxService é injetada no meu RentalService
         *  por meio do construtor.
         * */

        rentalService.processInvoice(cr);

        System.out.println("INVOICE:");
        System.out.println("Basic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));

        sc.close();
    }
}