package model.services;

public class Paypal implements PaymentService {

	@Override
	public double monthlyInterest(double amount, int numberInstallments, int month) {
		return  (amount / numberInstallments) + (amount / numberInstallments * 0.01 * month);
	}

	@Override
	public double paymentFee(double amount) {
		return amount + (amount * 0.02);
	}
}
