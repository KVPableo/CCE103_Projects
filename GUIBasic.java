package main;

import javax.swing.*;

public class GUIBasic {

	public GUIBasic( ) {
		JFrame frame = new JFrame("Pableo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(350, 200);
		frame.setVisible(true);
		frame.setResizable(false);
		
		JLabel type = new JLabel("Customer Type");
		JTextField txt1 = new JTextField();
		JLabel con = new JLabel("Consumption");
		JTextField txt3 = new JTextField();
		JLabel total = new JLabel("Total Bill");
		JTextField txt2 = new JTextField();
		JButton btn1 = new JButton("Add");
		JButton btn2 = new JButton("Delete");
		JButton btn3 = new JButton("Update");
		
		frame.add(type);
		frame.add(con);
		frame.add(total);
		frame.add(txt1);
		frame.add(txt2);
		frame.add(txt3);
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		
		type.setBounds(30, 30, 100, 25);
		con.setBounds(30, 60, 100, 25);
		total.setBounds(30, 90, 100, 25);
		
		txt1.setBounds(150, 30, 150, 25);
		txt2.setBounds(150, 60, 150, 25);
		txt3.setBounds(150, 90, 150, 25);
		
		btn1.setBounds(30, 120, 80, 25);
		btn2.setBounds(125, 120, 80, 25);
		btn3.setBounds(220, 120, 80, 25);
		
		
		
	}
	public static void main(String[] args) {
		new GUIBasic();

	}

}
