package cce103;
import javax.swing.*;
import java.util.*;
public class Array2dGUI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [][] hotel = new int[7][5];
		
	do {
		String input = JOptionPane.showInputDialog(null, "1. View Rooms \n2. Check In \n3. Check Out \n4. Exit ", null);
		int in = Integer.parseInt(input);
		
		if (in == 1) {
			for (int i = 0; i < hotel.length; i++) {
				System.out.printf("Floor %d: ", (i+1));
			    for (int j = 0; j < hotel[i].length; j++) {
			        System.out.print(hotel[i][j] + " ");
			    }
			    System.out.println();
			}
		}
		else if (in == 2) {
			String flr = JOptionPane.showInputDialog(null, "Enter Floor (1-7)");
			int floor = Integer.parseInt(flr);

			String rm = JOptionPane.showInputDialog(null, "Enter Floor (1-5)");
			int room = Integer.parseInt(rm);
			
			for (int i = 0; i < hotel.length; i++) {

			        }
					if (hotel[floor][room] != 0) {
		JOptionPane.showMessageDialog(null, "Room Already Occupied");
			
			}else {
			hotel[(floor - 1)][(room - 1)] = 1;
			JOptionPane.showMessageDialog(null, "Check in Success!");
		
			}
		}
		else if(in == 3) {
			String flr = JOptionPane.showInputDialog(null, "Enter Floor (1-7)");
			int floor = Integer.parseInt(flr);

			String rm = JOptionPane.showInputDialog(null, "Enter Floor (1-5)");
			int room = Integer.parseInt(rm);
			
			for (int i = 0; i < hotel.length; i++) {

			
			if (hotel[floor][room] != 1) {
				JOptionPane.showMessageDialog(null, "Room Already Available");

				}else {
					hotel[(floor - 1)][(room - 1)] = -1;
					JOptionPane.showMessageDialog(null, "Check out Success!");
			}
		}
		}
		
	}while(JOptionPane.INPUT_VALUE_PROPERTY.equals(4));
	
}

}