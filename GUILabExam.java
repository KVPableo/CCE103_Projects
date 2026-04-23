package cce_103;
import javax.swing.*;
import java.io.*;

public class GUILabExam {
	
	public GUILabExam( ) {
		JFrame frame = new JFrame("Expense Tracker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(frame);
		frame.setLayout(null);
		frame.setSize(350, 350);
		
		JLabel name = new JLabel("Expense Tracker");
		frame.add(name);
		name.setBounds(140, 5, 200, 60);
		
		JLabel recnum = new JLabel("Receipt Number:");
		JTextField txtReciept = new JTextField();
		frame.add(txtReciept);
		frame.add(recnum);
		recnum.setBounds(20, 40 ,100 ,50);
		txtReciept.setBounds(140, 55, 150, 25);
		
		JLabel store = new JLabel("Store Name:");
		JTextField txtStore = new JTextField();
		frame.add(store);
		frame.add(txtStore);
		store.setBounds(20, 70 ,100 ,50);
		txtStore.setBounds(140, 85, 150, 25);
		
		JLabel cost = new JLabel("Total Cost:");
		JTextField txtCost = new JTextField();
		frame.add(cost);
		frame.add(txtCost);
		cost.setBounds(20, 100 ,100 ,50);
		txtCost.setBounds(140, 115, 150, 25);
		
		JLabel tax = new JLabel("Tax (12%):");
		JTextField txtTax = new JTextField();
		frame.add(tax);
		frame.add(txtTax);
		txtTax.setEditable(false);
		tax.setBounds(20, 155 ,100 ,50);
		txtTax.setBounds(140, 170, 150, 25);
		
		JLabel amount = new JLabel("Final Amount:");
		JTextField txtAmount = new JTextField();
		frame.add(amount);
		frame.add(txtAmount);
		txtAmount.setEditable(false);
		amount.setBounds(20, 185 ,100 ,50);
		txtAmount.setBounds(140, 200, 150, 25);
		
		
		JButton btnRec = new JButton("Record");
		frame.add(btnRec);
		btnRec.setBounds(45, 250 ,100 ,25);
		btnRec.addActionListener(e ->{
			
			double ccost = Double.parseDouble(txtCost.getText());
			double totall = ccost * 0.12;
			double finalcost = ccost + totall;
			
			String finaltax = String.valueOf(totall);
			txtTax.setText(finaltax);
			String famount = String.valueOf(finalcost);
			txtAmount.setText(famount);
			
			
			try {
				FileWriter fw = new FileWriter("Data.txt", false);
				fw.write(txtReciept.getText() + " " + txtStore.getText() + " " + txtCost.getText() + " " + txtTax.getText() + " " + txtAmount.getText());
				fw.close();
					
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(btnRec, "Data save to text file!");
			
		});

		JButton btnDelete = new JButton("Delete");
		frame.add(btnDelete);
		btnDelete.setBounds(170, 250 ,100 ,25);
		btnDelete.addActionListener(e ->{
			
			txtReciept.setText("");
			txtStore.setText("");
			txtCost.setText("");
			txtTax.setText("");
			txtAmount.setText("");
			
			
		});
		
	}

	public static void main(String[] args) {
		new GUILabExam();

	}

}
