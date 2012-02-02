package accountManager.controller;

import org.w3c.dom.events.EventException;

import accountManager.model.AccountsModel;
import accountManager.view.AccountsView;
import accountManager.view.DepositAgentView;
import accountManager.view.JFrameView;
import accountManager.view.AgentView;
import accountManager.controller.AgentThread;

public class AgentController extends AbstractController  implements Runnable{

public int accountIndex=0;

public String agentType;
public int agentIDNum;
public int agentPick;
public double agentAmount;
public double agentSleep;


Thread t;
//AgentThread myThread;//=new Thread();
public volatile boolean alive;
	
	public AgentController(AccountsModel model,int pick,int agentID, double opsPerSecond, String operation,double amount){
		
		setModel(model);
		setView(new AgentView(model, this, pick, agentID, opsPerSecond, operation, amount));
		((JFrameView)getView()).setVisible(true);
		
		agentAmount=amount;
		accountIndex=pick;
		agentType=operation;
		agentSleep=opsPerSecond;
		
		//myThread=new AgentThread(operation,agentID, amount, opsPerSecond);
	    t=new Thread(this);//.start();
		t.start();
	    alive=true;
		
	    //myThread.start();
	}
	synchronized public void operation(String option){
		
		
		
		if(option.equals(AgentView.STOP))
		{
			//int pick=((AgentView)getView()).getPick();
			alive=false;
			//myThread=null;
			//myThread.interrupt();
			notifyAll();
			t=null;
		    
			((AgentView)getView()).dispose();
			
			if(agentType.equals("DAGENT"))
			{
				new DepositAgentController((AccountsModel)getModel(),agentPick);
			}
			else if(agentType.equals("WAGENT"))
			{
				new WithdrawAgentController((AccountsModel)getModel(),agentPick);
			}	
			
			
			//myThread.stop();
			
			//myThread=null;
			//myThread.stop();
			//notifyAll();
			//new AgentController((AccountsModel)getModel(),pick,);
			
		}
		
		else if(option.equals(AgentView.DISMISS))
		{
			alive=false;
			//myThread=null;
			//myThread.interrupt();
			notifyAll();
			t=null;
			
			((AgentView)getView()).dispose();
			
		}
		
		
		
	}
	
	public void run()
	{
		
		if(agentType.equals("DAGENT"))
		{
			while(alive)//alive)
			{
				try{
			  //System.out.println("hello deposit Thread world");	
				
			  
				((AccountsModel)getModel()).deposit(accountIndex,agentAmount);
				System.out.print("up"+ agentAmount);
				//t.sleep(1000);
				t.sleep((long) (1000/agentSleep));
				
				}
				 catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		}
		else if(agentType.equals("WAGENT"))
		{
			while(alive)//alive)
			{try{
				((AccountsModel)getModel()).withdraw(accountIndex,agentAmount);
				
				System.out.print("down"+ agentAmount);
				//t.sleep(1000);
				t.sleep((long) (1000/agentSleep));
				}
				 catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}	
		
		
	}
	/*
	synchronized public void  deposit(int accountIndex,double giveValue)
	{
		((AccountsModel)getModel()).withdraw(accountIndex,giveValue);
	}
	synchronized public void  withdraw(int accountIndex,double takeValue)
	{
		((AccountsModel)getModel()).withdraw(accountIndex,takeValue);
	}*/

}
