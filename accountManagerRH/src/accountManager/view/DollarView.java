package accountManager.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import accounts.controller.AccountsController;
import accountManager.controller.DollarController;
import accountManager.model.AccountsModel;
import accountManager.model.ModelEvent;

public class DollarView extends JFrameView {
	
	
	public static final String DEPOSIT="Deposit";
	public static final String WITHDRAW="Withdraw";
	public static final String DISMISS="Dismiss";
	
	double editFieldText;
	
	
	//probably in a subview
	private JTextField textField = new JTextField();
	
	JTextField editField=new JTextField();
	
	int userID;
	
	
	
	public DollarView(AccountsModel model, DollarController controller, int pick)
	{
		super(model, controller);
		
		userID=pick;
		double accountvalue=((AccountsModel)getModel()).getAccountValue(pick);
		
		String user=((AccountsModel)getModel()).getAName(pick);
		this.setTitle(user + " $ ");
		
		textField.setText("$ " + accountvalue);
		
		editField.setText("0.00");
		
		
		
		this.getContentPane().add(textField,BorderLayout.NORTH); 
		this.getContentPane().add(editField,BorderLayout.CENTER); 
		
		JPanel buttonPanel=new JPanel();

		Handler handler=new Handler();
		EditFieldHandler editHandler=new EditFieldHandler();
		
		JButton jbuttonDep= new JButton(DEPOSIT);
		jbuttonDep.addActionListener(handler);
		JButton jbuttonWith= new JButton(WITHDRAW);
		jbuttonWith.addActionListener(handler);
		JButton jbuttonDis= new JButton(DISMISS);
		jbuttonDis.addActionListener(handler);
		
		editField.addActionListener(editHandler);
		
		
		
		buttonPanel.setLayout(new GridLayout(3,2));
		
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);  //maybe CENTER instead
		
		buttonPanel.add(jbuttonDep,null);
		buttonPanel.add(jbuttonWith,null);
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
		
		if(event.getId()==userID)
		{
		String msg= "$ "+event.getAmount();
		textField.setText(msg);
		}
		
	}
		
	
	class Handler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//editable textfield
			//String editVAL= editField.getText();
				
			((DollarController)getController()).operation(e.getActionCommand());
		}
	}
	
	class EditFieldHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String editFieldStuff=editField.getText();

			//System.out.println("this is what it got"+editFieldStuff);
			
			editFieldText= Double.parseDouble(editFieldStuff);
			
			//System.out.println("this is what it became: "+editFieldText);
			
		}
	}
	
	
	//public static void main(String [] args){new AccountsController();}

}
