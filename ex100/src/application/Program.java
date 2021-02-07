package application;

import java.util.Scanner;

public class Program {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n,m;
        m = sc.nextInt();
        n = sc.nextInt();
     
        int[][] mat1 = new int[m][n];
        
        for (int i=0; i < mat1.length; i++){
            for (int j=0; j < mat1[i].length; j++){
                mat1[i][j] = sc.nextInt();
            }
        }
        
        int selectedNumber;
        selectedNumber = sc.nextInt();
        
        for (int i=0; i < mat1.length; i++){
            for (int j=0; j < mat1[i].length; j++){
                if (mat1[i][j] == selectedNumber){
                    System.out.println("Position " + i + "," + j + ":" );
                    if (j !=0){
                        System.out.println("Left: "+mat1[i][j-1]);
                    }
                    if (i != 0){
                        System.out.println("Up: "+ mat1[i-1][j]);
                    }
                    if (j + 1 != mat1[i].length){
                        System.out.println("Right: "+mat1[i][j+1]);
                    }
                    if (i + 1 != mat1.length){
                        System.out.println("Down: "+mat1[i+1][j]);
                    }
                }
            }
        }
        
        sc.close();
    }
}
