package entities;

public class ImportedProduct extends Product {
		
	private Double customsFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	@Override
	public String priceTag() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(super.getName());
		strBuilder.append(" $ ");
		strBuilder.append(totalPrice());
		strBuilder.append(" (Customs fee: $ ");
		strBuilder.append(customsFee);
		strBuilder.append(")\n");
		return strBuilder.toString();
	}
	
	public Double totalPrice() {
		return super.getPrice() + customsFee;
	}
}
