package accountManager.controller;

import accountManager.model.AccountsModel;
import accountManager.view.JFrameView;
import accountManager.view.YenView;

public class YenController extends AbstractController {

private double yenExchange= 94.1;
public int accountIndex=0;
	
	public YenController(AccountsModel model,int pick){
		//setModel(new AccountsModel());
		setModel(model);
		setView(new YenView(model, this, pick));
		((JFrameView)getView()).setVisible(true);
		
		accountIndex=pick;
	}
	public void operation(String option){
		
		//if(option.equals(AccountsView.DOLLAR))
		//{
		//  ((AccountsModel)getModel()).dollarEdit();
		//}
		
		if(option.equals(YenView.DEPOSIT))
		{
			double giveValue= ((YenView)getView()).getEditField();
			
			giveValue=giveValue/yenExchange;
			
			((AccountsModel)getModel()).deposit(accountIndex,giveValue);
			
		}
		else if(option.equals(YenView.WITHDRAW))
		{
			double takeValue= ((YenView)getView()).getEditField();
			takeValue=takeValue/yenExchange;
			
			((AccountsModel)getModel()).withdraw(accountIndex,takeValue);
		}
		else if(option.equals(YenView.DISMISS))
		{
			((YenView)getView()).dispose();
		}
		
		
		
	}

}
