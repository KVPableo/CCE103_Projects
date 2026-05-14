package main;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.io.*;
import java.util.ArrayList;
public class LabExam2 extends JFrame {
	static DefaultTableModel model;
	static JTable table;
	static JScrollPane scroll;
	static JFrame frame;
	static JTextField txtName, txtCourse, txtYearlvl, txtBalance, txtStatus;
	static JLabel name, course, yearlvl, balance, status;
	static JButton btnAdd, btnUpdate, btnDelete, btnClear;
	
	public LabExam2 ( ) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900,500);
		setVisible(true);
		setTitle("School Canteen Wallet");
		setResizable(false);
		
		
		String[] columns = {"Fullname","Course/Dept","Year Level","Wallet Balance", "Status"};
		model = new DefaultTableModel(columns,0);
		table = new JTable(model);
		scroll = new JScrollPane(table);
		add(scroll).setBounds(360,30,500,400);	
		scroll.setEnabled(false);
		
		File f = new File("StudentWallet.txt");
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		name = new JLabel("Name");
		add(name).setBounds(20,5,100,50);
		txtName = new JTextField();
		add(txtName).setBounds(20,45,200,25);
		
		course = new JLabel("Course/Dept");
		add(course).setBounds(20,65,100,50);
		txtCourse = new JTextField();
		add(txtCourse).setBounds(20,105,200,25);
		
		yearlvl = new JLabel("Year Level");
		add(yearlvl).setBounds(20,125,100,50);
		txtYearlvl = new JTextField();
		add(txtYearlvl).setBounds(20,165,200,25);
		
		balance = new JLabel("Wallet Balance");
		add(balance).setBounds(20,185,100,50);
		txtBalance = new JTextField();
		add(txtBalance).setBounds(20,225,200,25);
		
		status = new JLabel("Status (Active or Suspended)");
		add(status).setBounds(20,245,200,50);
		txtStatus = new JTextField();
		add(txtStatus).setBounds(20,285,200,25);
		
		btnAdd = new JButton("Add");
		add(btnAdd).setBounds(20,320,150,25);
		btnUpdate = new JButton("Update");
		add(btnUpdate).setBounds(20,360,150,25);
		btnDelete = new JButton("Delete");	
		add(btnDelete).setBounds(20,400,150,25);
		btnClear = new JButton("Clear");
		add(btnClear).setBounds(190,320,150,25);
		refresh();
		
		btnAdd.addActionListener(e ->{
			if(txtName.getText().isBlank() || txtCourse.getText().isBlank() || txtYearlvl.getText().isBlank()||txtBalance.getText().isBlank()||txtStatus.getText().isBlank()) {
				JOptionPane.showMessageDialog(null,"Some textfields are empty");
				return;
			}
			if (!txtStatus.getText().equals("Active") && !txtStatus.getText().equals("Suspended")) {
				JOptionPane.showMessageDialog(null,"Only input 'Active' or 'Suspended'");
				return;
				}
				try {
					FileWriter fw = new FileWriter("StudentWallet.txt",true);
					fw.write(txtName.getText()+"#"+txtCourse.getText()+"#"+txtYearlvl.getText()+"#"+txtBalance.getText()+"#"+txtStatus.getText()+"\n");	
					fw.close();
					refresh();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			JOptionPane.showMessageDialog(null,"Data saved to Text file!");
			clear();
			
		});
		
		btnDelete.addActionListener(e ->{
			int selected = table.getSelectedRow();
			ArrayList<String> lines = new ArrayList<>();
			try {
				BufferedReader br = new BufferedReader(new FileReader("StudentWallet.txt"));
				String line;
				int indRow = 0;
				while((line=br.readLine())!=null) {
					if (indRow != selected) {
						lines.add(line);
						indRow++;
					}
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("StudentWallet.txt"));
				for(String replace:lines)
					bw.write(replace+"\n");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			refresh();
		});
		
		btnUpdate.addActionListener(e ->{
			int selected = table.getSelectedRow();
			ArrayList<String> lines = new ArrayList<>();
			try {
				BufferedReader br = new BufferedReader(new FileReader("StudentWallet.txt"));
				String line;
				int indRow = 0;
				while((line=br.readLine())!=null) {
					String newLine = txtName.getText()+"#"+txtCourse.getText()+"#"+txtYearlvl.getText()+"#"+txtBalance.getText()+"#"+txtStatus.getText();
					if (indRow == selected) {
						lines.add(newLine);
					}else {
						lines.add(line);
					}
					indRow++;
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("StudentWallet.txt"));
				for(String replace:lines)
					bw.write(replace+"\n");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			refresh();
			
		});
		btnClear.addActionListener(e ->{
			clear();
		});
	}
	
	public static void clear() {
		txtName.setText("");
		txtCourse.setText("");
		txtYearlvl.setText("");
		txtBalance.setText("");
		txtStatus.setText("");
	
		
	}
	public static void refresh() {
		model.setRowCount(0);
		try {
			BufferedReader br = new BufferedReader(new FileReader("StudentWallet.txt"));
			String linen;
			
			while((linen=br.readLine())!=null) {
				String rows[] = linen.split("#");
				model.addRow(rows);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new LabExam2();

	}

}
