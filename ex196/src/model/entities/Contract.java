package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	private Integer number;
	private Date date;
	private Double totalValue;
	private List<Installment> installments;
	
	private static StringBuilder sb = new StringBuilder();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Contract() {
	}

	public Contract(Integer number, Date date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
		this.installments = new ArrayList<>();
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}
	
	public void addInstallment(Installment installment) {
		this.installments.add(installment);
	}
	
	@Override
	public String toString() {
		sb.append("Installments:\n");
		for (Installment inst : installments) {
			sb.append(sdf.format(inst.getDueDate()));
			sb.append(" - ");
			sb.append(inst.getAmount());
			sb.append("\n");
		}
		return sb.toString();
	}
}
