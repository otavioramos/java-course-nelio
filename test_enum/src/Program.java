import java.text.ParseException;

import entities.Person;
import entities.enums.PersonStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Person p1 = new Person("Otavio","Ramos","17/07/2000",PersonStatus.EMPLOYED);
		
		System.out.println(p1);
	}

}
