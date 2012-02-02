package accountManager.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import accountManager.view.DepositAgentView;

//import accounts.controller.AccountsController;
import accountManager.controller.AgentController;
import accountManager.model.AccountsModel;
import accountManager.model.AgentModel;
import accountManager.model.ModelEvent;

public class AgentView extends JFrameView {
	
	
	public static final String STOP="Stop Agent";
	
	public static final String DISMISS="Dismiss";
	
	double editFieldText;
	//AgentModel agentManager;
	
	
	//probably in a subview
	//private JTextField textField = new JTextField();
	
	//JTextField editField=new JTextField();
	
	JTextField agentIDField=new JTextField();
	JTextField amountInDollarsField=new JTextField();
	JTextField opsPerSecondField=new JTextField();
	
	
	
	public AgentView(AccountsModel model, AgentController controller, int pick, int agentID, double opsPerSecond, String operation, double amount)
	{
		super(model, controller);
		
		double accountvalue=((AccountsModel)getModel()).getAccountValue(pick);
		
		
		
		//String user=((AccountsModel)getModel()).getAName(pick);
		//this.setTitle(user + "  ");
		if(operation.equals("DAGENT"))
			this.setTitle("Deposit Agent");
		else if (operation.equals("WAGENT"))
			this.setTitle("Withdraw Agent");
		//textField.setText("$ " + accountvalue);
		
		//editField.setText("0.00");
		
		
		//HW3 stuff
		JPanel textPanel=new JPanel();
		
		textPanel.setLayout(new GridLayout(3,2));
		
		textPanel.add(new JLabel("Agent ID:"),null);
		AgentModel agentManager=((AccountsModel)getModel()).getAgentManager();
		//int goodID=agentManager.addID(agentID);
		
		agentIDField.setText(String.valueOf(agentID));
		textPanel.add(agentIDField,null);
		
		textPanel.add(new JLabel("Amount in $"),null);
		amountInDollarsField.setText(String.valueOf(amount));
		textPanel.add(amountInDollarsField,null);
		
		textPanel.add(new JLabel("Operations Per Second:"),null);
		opsPerSecondField.setText(String.valueOf(opsPerSecond));
		textPanel.add(opsPerSecondField,null);
		
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
		EditFieldHandler editHandler=new EditFieldHandler();
		
		
		JButton jbuttonStart= new JButton(STOP);
		jbuttonStart.addActionListener(handler);
		JButton jbuttonDis= new JButton(DISMISS);
		jbuttonDis.addActionListener(handler);
		
		//editField.addActionListener(editHandler);
		
		
		
		buttonPanel.setLayout(new GridLayout(3,2));
		
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);  //maybe CENTER instead
		
		//buttonPanel.add(jbuttonDep,null);
		//buttonPanel.add(jbuttonWith,null);
		buttonPanel.add(jbuttonStart,null);
		buttonPanel.add(jbuttonDis,null);
		
		
		pack();
		
	}
	
	//accessors
	public double getEditField()
	{ 
		return editFieldText;
	}
	
	@Override
	public void modelChanged(ModelEvent event)
	{
		//needs further implementation
		//String msg= "$ "+event.getAmount();
		//textField.setText(msg);
	}
	
	class Handler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//editable textfield
			//String editVAL= editField.getText();
				
			((AgentController)getController()).operation(e.getActionCommand());
		}
	}
	
	class EditFieldHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//String editFieldStuff=editField.getText();

			//System.out.println("this is what it got"+editFieldStuff);
			
			//editFieldText= Double.parseDouble(editFieldStuff);
			
			//System.out.println("this is what it became: "+editFieldText);
			
		}
	}
	
	
	//public static void main(String [] args){new AccountsController();}

}
