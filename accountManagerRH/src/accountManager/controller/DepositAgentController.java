package accountManager.controller;

import accountManager.model.AccountsModel;
import accountManager.view.AccountsView;
import accountManager.view.JFrameView;
import accountManager.view.DepositAgentView;

public class DepositAgentController extends AbstractController {

Thread myThread;	
private double yenExchange= 94.1;
public int accountIndex=0;
	
	public DepositAgentController(AccountsModel model,int pick){
		//setModel(new AccountsModel());
		setModel(model);
		setView(new DepositAgentView(model, this, pick));
		((JFrameView)getView()).setVisible(true);
		
		accountIndex=pick;
	}
	public void operation(String option){
		
		//if(option.equals(AccountsView.DOLLAR))
		//{
		//  ((AccountsModel)getModel()).dollarEdit();
		//}
		
		if(option.equals(DepositAgentView.START))
		{
			int pick=((DepositAgentView)getView()).getPick();
			
		new AgentController((AccountsModel)getModel(),pick,((DepositAgentView)getView()).getAgentIDField(),((DepositAgentView)getView()).getOpsPerSecondField(), DepositAgentView.DAGENT, ((DepositAgentView)getView()).getAmount());
			//myThread.start();
		    
			((DepositAgentView)getView()).dispose();
			
		}
		
		else if(option.equals(DepositAgentView.DISMISS))
		{
			((DepositAgentView)getView()).dispose();
		}
		
		
		
	}

}
