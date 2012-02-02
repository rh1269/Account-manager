package accountManager.controller;

import accountManager.view.AgentView;
import accountManager.view.View;
import accountManager.controller.AgentController;
import accountManager.view.JFrameView;

public class AgentThread extends Thread implements Runnable{

	String threadtype; 
	int threadid;
	double threadamount;
	int threadopsPerSecond;	
	
	public AgentThread (String type, int id,double amount,double opsPerSecond)
	{
	
		threadtype=type;
		
	}
	public void run()
	{
		
		if(threadtype.equals("DAGENT"))
		{
			while(!Thread.currentThread().isInterrupted())//alive)
			{
			  System.out.println("hello deposit Thread world");	
			}
		    
		}
		else if(threadtype.equals("WAGENT"))
		{
			while(true)//alive)
			{
				
			}
			
		}	
		
		
	}
}
