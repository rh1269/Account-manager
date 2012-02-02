package accountManager.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import accounts.controller.AccountsController;
import accountManager.controller.WithdrawAgentController;
import accountManager.model.AccountsModel;
import accountManager.model.ModelEvent;

public class WithdrawAgentView extends JFrameView {
	
	
	public static final String START="Start Agent";
	
	public static final String DISMISS="Dismiss";
	public static final String DAGENT="DAGENT";
	public static final String WAGENT="WAGENT";
	
	
    int agentIDFieldText;
	double opsPerSecondFieldText;
	double amountInDollarsFieldText;
	
	int currentPick;
	
	
	//probably in a subview
	//private JTextField textField = new JTextField();
	
	//JTextField editField=new JTextField();
	
	JTextField agentIDField=new JTextField();
	JTextField amountInDollarsField=new JTextField();
	JTextField opsPerSecondField=new JTextField();
	
	
	
	public WithdrawAgentView(AccountsModel model, WithdrawAgentController controller, int pick)
	{
		super(model, controller);
		
		currentPick=pick;
		
		double accountvalue=((AccountsModel)getModel()).getAccountValue(pick);
		
		//String user=((AccountsModel)getModel()).getAName(pick);
		//this.setTitle(user + "  ");
		this.setTitle("Create Withdraw Agent");
		//textField.setText("$ " + accountvalue);
		
		//editField.setText("0.00");
		
		
		//HW3 stuff
		JPanel textPanel=new JPanel();
		
		textPanel.setLayout(new GridLayout(3,2));
		
		textPanel.add(new JLabel("Agent ID:"),null);
		textPanel.add(agentIDField,null);
		agentIDField.setText("0");
		
		textPanel.add(new JLabel("Amount in $"),null);
		textPanel.add(amountInDollarsField,null);
		amountInDollarsField.setText("0.00");
		
		textPanel.add(new JLabel("Operations Per Second:"),null);
		textPanel.add(opsPerSecondField,null);
		opsPerSecondField.setText("1");
		
		this.getContentPane().add(textPanel,BorderLayout.NORTH);
		
		/*
		this.getContentPane().add(new JLabel("Agent ID:"),BorderLayout.WEST);
		this.getContentPane().add(agentIDField,BorderLayout.EAST); 
		
		this.getContentPane().add(new JLabel("Amount in $:"),BorderLayout.WEST);
		this.getContentPane().add(amountInDollarsField,BorderLayout.EAST); 
		
		
		this.getContentPane().add(new JLabel("Operations Per Second:"),BorderLayout.WEST);
		this.getContentPane().add(opsPerSecondField,BorderLayout.EAST); 
		*/
		
		
		
		//this.getContentPane().add(textField,BorderLayout.NORTH); 
		//this.getContentPane().add(editField,BorderLayout.CENTER); 
		
		JPanel buttonPanel=new JPanel();

		Handler handler=new Handler();
		
		EditFieldHandler agentIDFieldHandler=new EditFieldHandler();
		
		EditFieldHandler amountInDollarsFieldHandler=new EditFieldHandler();
		
		EditFieldHandler opsPerSecondFieldHandler=new EditFieldHandler();
		
		
		JButton jbuttonStart= new JButton(START);
		jbuttonStart.addActionListener(handler);
		JButton jbuttonDis= new JButton(DISMISS);
		jbuttonDis.addActionListener(handler);
		
		//editField.addActionListener(editHandler);
		
		agentIDField.addActionListener(agentIDFieldHandler);
		amountInDollarsField.addActionListener(amountInDollarsFieldHandler);
		opsPerSecondField.addActionListener(opsPerSecondFieldHandler);
		
		
		buttonPanel.setLayout(new GridLayout(3,2));
		
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);  //maybe CENTER instead
		
		//buttonPanel.add(jbuttonDep,null);
		//buttonPanel.add(jbuttonWith,null);
		buttonPanel.add(jbuttonStart,null);
		buttonPanel.add(jbuttonDis,null);
		
		
		pack();
		
	}
	
	//accessors
	public int getAgentIDField()
	{ 
		System.out.println(agentIDFieldText);
		return agentIDFieldText;
	}
	public double getOpsPerSecondField()
	{ 
		return opsPerSecondFieldText;
	}
	public double getAmount()
	{ 
		return amountInDollarsFieldText;
	}
	
	
	@Override
	public void modelChanged(ModelEvent event)
	{
		//needs further implementation
		//String msg= "$ "+event.getAmount();
		//textField.setText(msg);
	}
	
	
	public int getPick()
	{
		return currentPick;
	}
	
	
	
	class Handler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//editable textfield
			//String editVAL= editField.getText();
				
			((WithdrawAgentController)getController()).operation(e.getActionCommand());
		}
	}
	
	class EditFieldHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//String editFieldStuff=editField.getText();
			String agentIDFieldStuff=agentIDField.getText();
			agentIDFieldText= Integer.parseInt(agentIDFieldStuff);
			
			String amountInDollarsFieldStuff=amountInDollarsField.getText();
			amountInDollarsFieldText= Double.parseDouble(amountInDollarsFieldStuff);
			
			
			String opsPerSecondFieldStuff=opsPerSecondField.getText();
			opsPerSecondFieldText= Double.parseDouble(opsPerSecondFieldStuff);
			
			
			
			
			
			
			
			
			//System.out.println("this is what it became: "+editFieldText);
			
		}
	}
	
	
	//public static void main(String [] args){new AccountsController();}

}
