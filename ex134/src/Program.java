import entities.LegalPerson;
import entities.NaturalPerson;
import entities.Payer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        List<Payer> listPayers = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int qtPayers = sc.nextInt();

        // Adding payers data
        for (int i = 1; i <= qtPayers; i++){
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char typeOfPayer = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();;
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();

            // Depending of type of Payer chosen above
            if (typeOfPayer == 'c'){
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                listPayers.add(new LegalPerson(name, anualIncome, numberOfEmployees));
            }else {
                System.out.print("Health expenditures: ");
                double healthSpending = sc.nextDouble();
                listPayers.add(new NaturalPerson(name, anualIncome, healthSpending));
            }
        }

        double total = 0;

        // Print tax information
        System.out.println("\nTAXES PAID:");
        for (Payer payer : listPayers){
            System.out.print(payer.getName() + " $ "
                    + String.format("%.2f",payer.calculateTax())
                    + "\n");
            total += payer.calculateTax();
        }

        // Total Taxes
        System.out.println("\nTOTAL TAXES: $ " + String.format("%.2f", total));

        sc.close();

    }
}
