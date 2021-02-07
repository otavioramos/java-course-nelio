import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int qtdEmployees;
        int idEmployee;
        double percentageToIncrease;
        List<Employee> list = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        qtdEmployees = sc.nextInt();

        for (int i = 0; i < qtdEmployees; i++){
            System.out.println("\nEmployee #" + (i + 1) + ":");
            System.out.print("Id: ");
            int id = sc.nextInt();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);
            list.add(emp);
        }

        System.out.print("\nEnter the employee id that will have salary increase: ");
        idEmployee = sc.nextInt();
        Integer psOfEmployee = position(list, idEmployee);
        if (psOfEmployee == null){
            System.out.println("This id does not exist!");
        }else{
            System.out.print("\nEnter the percentage: ");
            percentageToIncrease = sc.nextDouble();
            list.get(psOfEmployee).increaseSalary(percentageToIncrease);
        }

        System.out.println("List of employees:");
        for (Employee emp : list){
            System.out.println(emp.getId() + ", " + emp.getName() + ", " + emp.getSalary());
        }

        sc.close();
    }
    public static Integer position(List<Employee> list, int id){
        for (int i=0; i< list.size(); i++){
            if (list.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }
}
