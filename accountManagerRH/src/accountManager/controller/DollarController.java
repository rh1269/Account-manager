package accountManager.controller;

import accountManager.model.AccountsModel;
import accountManager.view.DollarView;
import accountManager.view.JFrameView;
//import accounts.view.AccountsView;

public class DollarController extends AbstractController {
	
	public int accountIndex=0;
	
	public DollarController(AccountsModel model,int pick){
		//setModel(new AccountsModel());
		setModel(model);
		setView(new DollarView(model, this, pick));
		((JFrameView)getView()).setVisible(true);
		
		accountIndex=pick;
	}
	public void operation(String option){
		
		//if(option.equals(AccountsView.DOLLAR))
		//{
		//  ((AccountsModel)getModel()).dollarEdit();
		//}
		
		if(option.equals(DollarView.DEPOSIT))
		{
			double giveValue= ((DollarView)getView()).getEditField();
			
			((AccountsModel)getModel()).deposit(accountIndex,giveValue);
			
		}
		else if(option.equals(DollarView.WITHDRAW))
		{
			double takeValue= ((DollarView)getView()).getEditField();
			((AccountsModel)getModel()).withdraw(accountIndex,takeValue);
		}
		else if(option.equals(DollarView.DISMISS))
		{
			((DollarView)getView()).dispose();
		}
		
		
		
	}

}
