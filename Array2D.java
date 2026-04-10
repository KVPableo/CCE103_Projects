package cce103;
import java.util.Arrays;
import java.util.Scanner;
public class Array2D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [][] hotel = new int[7][5];
		
			int input;
		do {
			System.out.printf("1. View Rooms \n2. Check In \n3. Check Out \n4. Exit \nEnter Choice: ");
				input = sc.nextInt();
			
			if (input == 1) {
				for (int i = 0; i < hotel.length; i++) {
					System.out.printf("Floor %d: ", (i+1));
				    for (int j = 0; j < hotel[i].length; j++) {
				        System.out.print(hotel[i][j] + " ");
				    }
				    System.out.println(); // Moves to next line after each row
				}
			}
			else if (input == 2) {
				System.out.printf("Enter Floor (1-7): ");
				int floor = sc.nextInt();
				System.out.printf("Enter Room (1-5): ");
				int room = sc.nextInt();
				
				for (int i = 0; i < hotel.length; i++) {

				        }
						if (hotel[floor][room] != 0) {
				System.out.println("Room Already Occupied");
				
				}else {
				hotel[(floor - 1)][(room - 1)] = 1;
						System.out.println("Check in Success!");
				}
			}
			else if(input == 3) {
				System.out.printf("Enter Floor (1-7): ");
				int floor = sc.nextInt();
				System.out.printf("Enter Room (1-5): ");
				int room = sc.nextInt();
				
				if (hotel[floor][room] != 1) {
					System.out.println("Room Already Available");
					
					}else {
						hotel[(floor - 1)][(room - 1)] = 0;
						System.out.println("Check out Success!");
				}
			}
			
		}while(input != 4);
		
	}

}
