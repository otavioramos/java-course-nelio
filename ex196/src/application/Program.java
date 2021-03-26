package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.services.ContractService;
import model.services.Paypal;

public class Program {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Enter contract data:");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double value = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		int numberInstallments = sc.nextInt();
		
		ContractService contractService = new ContractService(
				numberInstallments,
				new Paypal());
		contractService.setContract(number, date, value);
	
		sc.close();
	}

}
