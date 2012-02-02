package accountManager.model;

import java.util.ArrayList;
import java.io.*;

import accountManager.controller.AbstractController;
import accountManager.model.AccountsModel;
import accountManager.view.AccountsView;
import accountManager.view.JFrameView;

public class AgentModel extends AbstractModel /*extends AbstractController*/{

	
	public ArrayList<Integer> agentIDarray;
	int totalNum;
	
	public AgentModel()//AccountsModel model)
	{
		//setModel(model);
		//agentIDarray.
		
	}
	
	public int addID(int ID)
	{
	  //totalNum=agentIDarray.size();
	 //System.out.println("id array size = "+agentIDarray.size());	
	totalNum=0;
	
	  boolean taken=false;
	  int id=ID;
	  
	  for(int x=0;x<totalNum+1;x++)
	  {
		  if(ID==agentIDarray.get(x))
		  {
			  taken=true;
		  }
	  }
	  
	  if(taken)
	  {
		  System.out.println("ID IS ALREADY TAKEN...REASSIGNING ID");
		  id=findOpenID();
	  }
	  
	  agentIDarray.add(id);
	  
	  return id;
		  
	}
	
	public int findOpenID()
	{
		int totalNum=agentIDarray.size();
		//int searchArea=totalNum*2;
		
		int id=0;
		boolean taken=true;
		
		while(taken){
		
		if(agentIDarray.contains(id)==false)
		{
			taken= false;
		}
		id++;
		
		}
		 
		return id;
		
	}
	
	public boolean deleteID(int ID)
	{
		if(agentIDarray.contains(ID))
		{
			agentIDarray.remove(ID);
			return true;
		}
		
		else
			return false;
	}
	/*
	synchronized public void  deposit(int accountIndex,double giveValue)
	{
		((AccountsModel)getModel()).withdraw(accountIndex,giveValue);
	}
	synchronized public void  withdraw(int accountIndex,double takeValue)
	{
		((AccountsModel)getModel()).withdraw(accountIndex,takeValue);
	}
	*/
	
}
