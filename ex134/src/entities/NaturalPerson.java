package entities;

public class NaturalPerson extends Payer{

    private Double healthSpending;

    public NaturalPerson(){
        super();
    }

    public NaturalPerson(String name, Double anualIncome, Double healthSpending) {
        super(name, anualIncome);
        this.healthSpending = healthSpending;
    }

    // Getter and Setter
    public Double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(Double healthSpending) {
        this.healthSpending = healthSpending;
    }

    @Override
    public Double calculateTax() {
        if (anualIncome < 20000.00){
            return anualIncome * 0.15;
        }else {
            return (anualIncome * 0.25) - (healthSpending * 0.5);
        }
    }
}
