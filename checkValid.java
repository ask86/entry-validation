package project1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class checkValid extends JFrame {

	private JPanel contentPane;
	private JTextField text_name;
	private JTextField text_age;
	private JTextField text_sale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkValid frame = new checkValid();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public checkValid() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 283, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setBounds(10, 11, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("AGE:");
		lblAge.setBounds(10, 49, 46, 14);
		contentPane.add(lblAge);
		
		JLabel lblSale = new JLabel("SALE:");
		lblSale.setBounds(10, 86, 46, 14);
		contentPane.add(lblSale);
		
		text_name = new JTextField();
		text_name.setBounds(49, 8, 208, 20);
		contentPane.add(text_name);
		text_name.setColumns(10);
		
		text_age = new JTextField();
		text_age.setBounds(49, 46, 208, 20);
		contentPane.add(text_age);
		text_age.setColumns(10);
		
		text_sale = new JTextField();
		text_sale.setBounds(49, 83, 208, 20);
		contentPane.add(text_sale);
		text_sale.setColumns(10);
		
		//validating the entries
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag1;
				boolean flag2;
				boolean flag3;
				String user_name = text_name.getText();
				String user_age=text_age.getText();
				String user_sale=text_sale.getText();
				SwingValidator name= new SwingValidator();
				SwingValidator age= new SwingValidator();
				SwingValidator sale= new SwingValidator();
				
				//empty fields check
				if(user_name.equals("")&&user_age.equals("")&&user_sale.equals(""))
				{
					JOptionPane.showMessageDialog(null, "PLEASE ENTER THE DETAILS","ERROR", 
													JOptionPane.ERROR_MESSAGE, null);
					
				}
				else 
				{
					//user name field check
				flag1=name.booleanisNotEmpty(text_name,user_name);
					if(flag1==true)
					{
						 //age name field check
						flag2=age.booleanisInteger(text_age, user_age);
							if(flag2==true)
								{
									//sale field check
									flag3=sale.booleanisDouble(text_sale, user_sale);
				
									if(flag3==true)
									{
										//validation success
										String tempOut="Name: "+user_name+System.lineSeparator()+ "Age: "+
														user_age+System.lineSeparator()+ "Sale: "
														+user_sale +System.lineSeparator()+"VALID ENTRY";
					
										JOptionPane.showMessageDialog(null,tempOut ,"VALIDATOR TEST", 
																JOptionPane.INFORMATION_MESSAGE, null);
										text_name.setText("");
										text_age.setText("");
										text_sale.setText("");
									}
								}
					}
				}
			}
		});
		btnOk.setBounds(49, 111, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkValid.this.processWindowEvent(
	                        new WindowEvent(
	                                checkValid.this, WindowEvent.WINDOW_CLOSING));
				
			}
		});
		btnExit.setBounds(168, 111, 89, 23);
		contentPane.add(btnExit);
	}
}


class SwingValidator 
{
	
	public boolean booleanisNotEmpty(JTextField textname, String S)
	{
		if(S.equals(""))
		{
			  	
				JOptionPane.showMessageDialog(null, "PLEASE ENTER NAME","ERROR", 
												JOptionPane.ERROR_MESSAGE, null);
				return false;
		}
		else
		{
			return true;
		}
		
	}
	
	public boolean booleanisInteger(JTextField textage, String fieldage)
	{
		try
		{
			if(fieldage.equals(""))
			{
				  	
					JOptionPane.showMessageDialog(null, "PLEASE ENTER AGE VALUE","ERROR", 	
													JOptionPane.ERROR_MESSAGE, null);
					return false;
			}
			
			int tempAge;
			tempAge=Integer.parseInt(fieldage);
			return true;
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, "PLEASE ENTER CORRECT VALUE OF AGE","ERROR", 
												JOptionPane.ERROR_MESSAGE, null);
			return false;
		}
		
	}
	public boolean booleanisDouble(JTextField field, String fieldsale)
	
	{
		
		try
		{
			if(fieldsale.equals(""))
			{
				  	
					JOptionPane.showMessageDialog(null, "PLEASE ENTER VALUE OF SALE","ERROR", 
														JOptionPane.ERROR_MESSAGE, null);
					return false;
			}
			
			double tempSale;
			tempSale=Double.parseDouble(fieldsale);
			return true;
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, "PLEASE ENTER CORRECT VALUE OF AGE","ERROR", 
											JOptionPane.ERROR_MESSAGE, null);
			return false;
		}
	}
	
}