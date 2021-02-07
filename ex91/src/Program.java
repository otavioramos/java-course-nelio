import entities.ReservedRoom;

import java.util.Scanner;

public class Program {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        ReservedRoom[] reserve = new ReservedRoom[10];

        System.out.print("How many rooms will be rented? ");
        int qtReserves = sc.nextInt();

        for(int i = 1; i <= qtReserves; i++){
            System.out.print("\nRent #"+ i +":\n");
            System.out.print("Name:");
            String name = sc.next();
            System.out.print("Email:");
            String email = sc.next();
            System.out.print("Room:");
            int room = sc.nextInt();

            reserve[room] = new ReservedRoom(name,email);
        }

        System.out.println("Busy rooms:");
        for(int i = 0; i < reserve.length; i++){
            if(reserve[i] != null){
                System.out.println(i + ": " + reserve[i].getName() +", " + reserve[i].getEmail());
            }
        }
    }
}
