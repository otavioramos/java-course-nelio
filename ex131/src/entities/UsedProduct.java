package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date manufactureDate;

	public UsedProduct() {
		super();
	}
	
	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(super.getName());
		strBuilder.append(" (used) ");
		strBuilder.append("$ ");
		strBuilder.append(String.format("%.2f", super.getPrice()));
		strBuilder.append(" (Manufacture date: ");
		strBuilder.append(sdf.format(manufactureDate) + ")\n");
		return strBuilder.toString();
	}
}
