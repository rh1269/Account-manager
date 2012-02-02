package accountManager.controller;

import accountManager.model.AccountsModel;
import accountManager.view.AccountsView;
import accountManager.view.JFrameView;
import accountManager.view.WithdrawAgentView;

public class WithdrawAgentController extends AbstractController {

Thread myThread;	
private double yenExchange= 94.1;
public int accountIndex=0;
	
	public WithdrawAgentController(AccountsModel model,int pick){
		//setModel(new AccountsModel());
		setModel(model);
		setView(new WithdrawAgentView(model, this, pick));
		((JFrameView)getView()).setVisible(true);
		
		accountIndex=pick;
	}
	public void operation(String option){
		
		//if(option.equals(AccountsView.DOLLAR))
		//{
		//  ((AccountsModel)getModel()).dollarEdit();
		//}
		
		if(option.equals(WithdrawAgentView.START))
		{
			int pick=((WithdrawAgentView)getView()).getPick();
			
		new AgentController((AccountsModel)getModel(),pick,((WithdrawAgentView)getView()).getAgentIDField(),((WithdrawAgentView)getView()).getOpsPerSecondField(), WithdrawAgentView.WAGENT, ((WithdrawAgentView)getView()).getAmount());
			//myThread.start();
		    
			((WithdrawAgentView)getView()).dispose();
			
		}
		
		else if(option.equals(WithdrawAgentView.DISMISS))
		{
			((WithdrawAgentView)getView()).dispose();
		}
		
		
		
	}

}
