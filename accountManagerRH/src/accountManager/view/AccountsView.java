package accountManager.view;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

import accountManager.controller.AccountsController;
import accountManager.model.AccountsModel;
import accountManager.model.ModelEvent;

public class AccountsView extends JFrameView{

	public static final String DOLLAR = " Edit account in $ ";
	public static final String EURO="Edit account in Euros";
	public static final String YEN="Edit account in Yen";
	public static final String SAVE="Save";
	public static final String EXIT="Exit";
	
	//hw3
	
	public static final String DAGENT= "Create Deposit Agent";
	public static final String WAGENT= "Create Withdraw Agent";
	
	public int comboChoice;
	
	
	
	
	/**
	 * 
	 * @param model
	 * @param controller
	 */
	public AccountsView(AccountsModel model, AccountsController controller)
	{
		super(model, controller);
	
	String[] accountnames= ((AccountsModel)getModel()).getNames();
	
	JComboBox combo=new JComboBox(accountnames);
	
	this.getContentPane().add(combo,BorderLayout.NORTH); JPanel buttonPanel=new JPanel();
		

		Handler handler=new Handler();
		ComboHandler combohandler=new ComboHandler();
		
		
		JButton jbuttonDollar= new JButton(DOLLAR);
		jbuttonDollar.addActionListener(handler);
		JButton jbuttonEuro= new JButton(EURO);
		jbuttonEuro.addActionListener(handler);
		JButton jbuttonYen= new JButton(YEN);
		jbuttonYen.addActionListener(handler);
		JButton jbuttonSave=new JButton(SAVE);
		jbuttonSave.addActionListener(handler);
		JButton jbuttonExit=new JButton(EXIT);
		jbuttonExit.addActionListener(handler);
		
		//HW3
		JButton jbuttonDagent= new JButton(DAGENT);
		jbuttonDagent.addActionListener(handler);
		JButton jbuttonWagent= new JButton(WAGENT);
		jbuttonWagent.addActionListener(handler);
		
		
		//comboChoice= combo.getSelectedIndex();
		combo.addActionListener(combohandler);
		
		buttonPanel.setLayout(new GridLayout(3,2));
		
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);  //maybe CENTER instead
		
		buttonPanel.add(jbuttonDollar,null);
		buttonPanel.add(jbuttonEuro,null);
		buttonPanel.add(jbuttonYen,null);
		buttonPanel.add(jbuttonSave,null);
		
		
		//Hw3
		buttonPanel.add(jbuttonDagent,null);
		buttonPanel.add(jbuttonWagent,null);
		
		buttonPanel.add(jbuttonExit,null);
		
		
		this.setTitle("Account Manager");
		
		pack();
		
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCurrentCombo()
	{
		System.out.println("this was the choice "+ comboChoice);
		return comboChoice;
	}
	
	
	@Override
	/**
	 * 
	 */
	public void modelChanged(ModelEvent event)
	{
		//needs further implementation
	}
	
	

	class Handler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			((AccountsController)getController()).operation(e.getActionCommand());
		
		}
	}
	
	class ComboHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
	        JComboBox cb = (JComboBox)e.getSource();
	        comboChoice = cb.getSelectedIndex();
	       
		}
	}
	
	
	
}
