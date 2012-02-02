package accountManager.controller;

import java.util.ArrayList;

import accountManager.model.AccountsModel;
import accountManager.model.AgentModel;
import accountManager.view.AccountsView;
import accountManager.view.JFrameView;

public class AccountsController extends AbstractController {
	/**
	 * 
	 * @param accountNAME
	 * @param accountNUM
	 * @param accountVAL
	 * @param file
	 */
	public AccountsController(ArrayList<String> accountNAME,ArrayList<Integer>accountNUM,ArrayList<Double>accountVAL,String file){
		setModel(new AccountsModel(accountNAME,accountNUM,accountVAL,file));
		setView(new AccountsView((AccountsModel)getModel(), this));
		new AgentModel();
		((JFrameView)getView()).setVisible(true);
	}
	/**
	 * 
	 * @param option
	 */
	public void operation(String option){
		
		if(option.equals(AccountsView.DOLLAR))
		{
		
			int pick=((AccountsView)getView()).getCurrentCombo();
			
			new DollarController((AccountsModel)getModel(),pick);
			
		}
		
		else if(option.equals(AccountsView.EURO))
		{
		
			int pick=((AccountsView)getView()).getCurrentCombo();
			
			new EuroController((AccountsModel)getModel(),pick);
			
		}
		
		else if(option.equals(AccountsView.YEN))
		{
		
			int pick=((AccountsView)getView()).getCurrentCombo();
			
			new YenController((AccountsModel)getModel(),pick);
			
		}
		else if(option.equals(AccountsView.SAVE))
		{
				((AccountsModel)getModel()).save();
		}
		else if(option.equals(AccountsView.EXIT))
		{
			
			
			System.exit(1);
		}
		
		//HW 3 Start
		
		else if(option.equals(AccountsView.DAGENT))
		{
			int pick=((AccountsView)getView()).getCurrentCombo();
			
			new DepositAgentController((AccountsModel)getModel(),pick);
		}
		
		else if(option.equals(AccountsView.WAGENT))
		{
			int pick=((AccountsView)getView()).getCurrentCombo();
			
			new WithdrawAgentController((AccountsModel)getModel(),pick);
		}
		
		
		
		
	}

}
