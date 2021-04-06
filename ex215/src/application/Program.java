package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String,Integer> votes = new HashMap<>();
		
		System.out.print("Enter file full path: ");
		String path = sc.next();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line != null)	{
				String[] fields = line.split(",");
				if (votes.containsKey(fields[0])) {
					System.out.println(votes.get(fields[0]));
				}else {
					votes.put(fields[0], Integer.parseInt(fields[1]));
				}
				line = br.readLine();
			}
		} catch (Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
		}
		sc.close();
	}

}
