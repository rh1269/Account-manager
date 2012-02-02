package accountManager.controller;

import accountManager.model.AccountsModel;
import accountManager.view.EuroView;
import accountManager.view.JFrameView;
//import accounts.view.DollarView;

public class EuroController extends AbstractController {
	
	private final double  euroExchange=.79;
	public int accountIndex=0;
	
	public EuroController(AccountsModel model,int pick){
		//setModel(new AccountsModel());
		setModel(model);
		setView(new EuroView(model, this, pick));
		((JFrameView)getView()).setVisible(true);
		
		accountIndex=pick;
	}
	public void operation(String option){
		
		//if(option.equals(AccountsView.DOLLAR))
		//{
		//  ((AccountsModel)getModel()).dollarEdit();
		//}
		
		if(option.equals(EuroView.DEPOSIT))
		{
			double giveValue= ((EuroView)getView()).getEditField();
			
			giveValue=giveValue/euroExchange;
			
			((AccountsModel)getModel()).deposit(accountIndex,giveValue);
			
		}
		else if(option.equals(EuroView.WITHDRAW))
		{
			double takeValue= ((EuroView)getView()).getEditField();
			takeValue=takeValue/euroExchange;
			
			((AccountsModel)getModel()).withdraw(accountIndex,takeValue);
		}
		else if(option.equals(EuroView.DISMISS))
		{
			((EuroView)getView()).dispose();
		}
		
		
	}

}

