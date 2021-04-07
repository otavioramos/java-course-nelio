package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();

        System.out.print("Enter full file path: ");
        String path = sc.next();

        System.out.print("Enter Salary: ");
        Double targetSalary = sc.nextDouble();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Employee(fields[0],fields[1],Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            List<String> listEmpBySalary = list.stream()
                    .filter(s -> s.getSalary() > targetSalary)
                    .map(emp -> emp.getEmail())
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println("Email of people whose salary is more than " + targetSalary + ":");
            listEmpBySalary.forEach(System.out::println);

            double sumM = list.stream()
                    .filter(emp -> emp.getName().charAt(0) == 'M')
                    .map(x -> x.getSalary())
                    .reduce(0.0,(x,y) -> x + y);

            System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f",sumM));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
