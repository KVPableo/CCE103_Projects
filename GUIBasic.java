package main;

import javax.swing.*;
import java.io.*;

public class GUIBasic {

	public GUIBasic( ) {
		JFrame frame = new JFrame ("Pableo");
		frame.setLocationRelativeTo(null);
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		
		JLabel type = new JLabel("Costumer Type");
		JTextField inType = new JTextField();
		frame.add(type);
		frame.add(inType);
		type.setBounds(40, -20, 150, 100);
		inType.setBounds(150, 20, 150, 25);
		
		JLabel consumption = new JLabel("Consumption");
		JTextField inConsumption = new JTextField();
		frame.add(consumption);
		frame.add(inConsumption);
		consumption.setBounds(40, 10, 150, 100);
		inConsumption.setBounds(150, 50, 150, 25);
		
		JLabel bill = new JLabel("Bill");
		JTextField txtBill = new JTextField();
		txtBill.setEditable(false);
		frame.add(bill);
		frame.add(txtBill);
		bill.setBounds(40, 40, 150, 100);
		txtBill.setBounds(150, 80, 150, 25);
		
		JButton btnAdd = new JButton("Add");
		frame.add(btnAdd);
		btnAdd.setBounds(40, 120, 80, 25);
		
		btnAdd.addActionListener(e -> {		
			double con = Double.parseDouble(inConsumption.getText());
			double result = con * 135;
			String billtotal = String.valueOf(result);
			
			txtBill.setText(billtotal);
			
			
			try {
				FileWriter fw = new FileWriter("Vehicle.txt", false);
				
				fw.write(inType.getText() + " " + inConsumption.getText() + " " + billtotal);
				fw.close();
				

			} catch (IOException e1) {
					System.out.println(e1);
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "Result Save to Text file!");
			
			});
		
		
		
		
		JButton btnDelete = new JButton("Delete");
		frame.add(btnDelete);
		btnDelete.setBounds(130, 120, 80, 25);
		btnDelete.addActionListener(e ->{
			
			txtBill.setText("");
			inConsumption.setText("");
			inType.setText("");
				
		});
		

		JButton btnUpdate = new JButton("Update");
		frame.add(btnUpdate);
		btnUpdate.setBounds(220, 120, 80, 25);
		
	}
	

	public static void main(String[] args) {
		new GUIBasic();

	}

}
