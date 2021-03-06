package entities;

public class LegalPerson extends Payer {

    private Integer numberOfEmployees;

    public LegalPerson() {
        super();
    }
    public LegalPerson(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    // Getter and Setter
    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double calculateTax() {
        if (numberOfEmployees > 10){
            return anualIncome * 0.14;
        }else {
            return anualIncome * 0.16;
        }
    }
}
