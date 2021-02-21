package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entities.enums.PersonStatus;

public class Person {
	
	private String name;
	private String surname;
	private Date birthdate;
	private PersonStatus personStatus;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public Person(String name, String surname, String birthdate, PersonStatus personStatus) throws ParseException {
		this.name = name;
		this.surname = surname;
		this.birthdate = dateFormat.parse(birthdate);
		this.personStatus = personStatus;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", birthdate=" + birthdate + ", personStatus="
				+ personStatus + "]";
	}
}
