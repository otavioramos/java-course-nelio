package model.services;

public interface PaymentService {
	
	double monthlyInterest(double amount, int numberInstallments, int month);
	double paymentFee(double amount);
	
}
