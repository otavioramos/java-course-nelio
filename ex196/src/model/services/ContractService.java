package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
		
	private int numberInstallments;
	private PaymentService payment;
	
	public ContractService(int numberInstallments, PaymentService payment) {
		this.numberInstallments = numberInstallments;
		this.payment = payment;
	}

	public int getNumberInstallments() {
		return numberInstallments;
	}

	public void setNumberInstallments(int numberInstallments) {
		this.numberInstallments = numberInstallments;
	}

	public PaymentService getPayment() {
		return payment;
	}
	
	public void setContract(Integer number, Date date, Double totalValue) throws Exception {
		Contract contract = new Contract(number, date, totalValue);
		for (int i = 1; i <= numberInstallments; i++) {
			double monthlyInterest = payment.monthlyInterest(totalValue, numberInstallments, i);
			double paymentFee = payment.paymentFee(monthlyInterest);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, i);
			Date installmentDate = cal.getTime();
			Installment installment = new Installment(installmentDate, paymentFee);
			contract.addInstallment(installment);
		}
		System.out.print(contract.toString());
	}
}
