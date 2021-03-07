import model.entities.Account;
import model.exceptions.WithdrawLimitException;
import model.exceptions.WithdrawNoBalanceException;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        try {
            System.out.println("Enter amount data:");

            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            String holder = sc.nextLine();
            holder += sc.nextLine();
            System.out.print("Initial balance: ");
            double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account acc1 = new Account(number, holder, initialBalance, withdrawLimit);

            System.out.print("\nEnter amount for withdraw: ");
            acc1.withdraw(sc.nextDouble());
        }
        catch (WithdrawNoBalanceException e){
            System.out.println(e.getMessage());
        }
        catch (WithdrawLimitException e){
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
