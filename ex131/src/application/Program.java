package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> productsList = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char productType = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if (productType == 'i') {
				// Imported Product
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				Product impProduct = new ImportedProduct(name, price, customsFee);
				productsList.add(impProduct);
			} else if (productType == 'u') {
				// Used Product
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				Product usedProduct = new UsedProduct(name, price, manufactureDate);
				productsList.add(usedProduct);
			} else {
				// Common product
				Product commonProduct = new Product(name, price);
				productsList.add(commonProduct);
			}
			
		}
		
		
		// Showing price tags
		System.out.println("\nPRICE TAGS:");
		for (Product p : productsList) {
			System.out.print(p.priceTag());
		}
		
		sc.close();
		
	}

}
