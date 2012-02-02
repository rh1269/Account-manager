package accountManager.model;

import java.util.ArrayList;
import java.io.*;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class AccountsModel extends AbstractModel {
	
	//private int accountNUM[]={318,12,429};
	//private double accountVAL[]={25.0,70.0,80.5};
	//private String accountNAME[]={"BOB","Jim","Tom"};
	//JPopupMenu popupError;
	
	private int accountNUM[];
	private double accountVAL[];
	private String accountNAME[];
	AgentModel agentManager;
	
	private ArrayList<String> accountNAMElist;
	private ArrayList<Double>accountVALlist;
    private ArrayList<Integer> accountNUMlist;
    
    private String saveFile;
	
    
    /**
     * 
     * @param accountNAMEpass
     * @param accountNUMpass
     * @param accountVALpass
     * @param file
     */
	public AccountsModel(ArrayList<String> accountNAMEpass,ArrayList<Integer>accountNUMpass,ArrayList<Double>accountVALpass,String file)
	{
		accountNAMElist=accountNAMEpass;
		accountNUMlist=accountNUMpass;
		accountVALlist=accountVALpass;
		
		int num=accountNAMElist.size();
		
		accountNAME=new String[num];
		accountVAL=new double[num];
		accountNUM=new int[num];
		
		agentManager=new AgentModel();
		
		
		
		for(int i=0; i<num; i++)
		{
			accountNAME[i]=accountNAMElist.get(i);
			accountVAL[i]=accountVALlist.get(i);
			accountNUM[i]=accountNUMlist.get(i);
		}
		
		saveFile=file;
	}
	
	
	
	
	
	
//accessors
	
	/**
	 *  
	 */
	public AgentModel getAgentManager()
	{
		return agentManager;
	}
	
	
	public String[] getNames()
	{
		int num=accountNAMElist.size();
		
		String nameAndNum[]=new String[num];
		
		
		
		for(int i=0; i<num; i++)
		{
			nameAndNum[i]=accountNAMElist.get(i)+" : "+ accountNUM[i];
			
		}
		
		
		
		
		return nameAndNum;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public String getAName(int index)
	{
		return accountNAME[index];
		//return accountNAMElist.get(index);
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public double getAccountValue(int index)
	{
		return accountVAL[index];
		//return accountVALlist.get(index);
	}
	

	
	
	
	
	/**
	 * 
	 * @param index
	 * @param giveValue
	 */
synchronized public void deposit(int index,double giveValue)
	{
		System.out.print("so "+accountVAL[index]+" + "+ giveValue);
		
		accountVAL[index]+=giveValue;
		
		System.out.println(" = "+accountVAL[index]);
		
		
		ModelEvent me=new ModelEvent(this,index,"",accountVAL[index]);
		notifyChanged(me);
	}
	/**
	 * 
	 * @param index
	 * @param takeValue
	 */
synchronized public void withdraw(int index, double takeValue)
	{
		
		if(takeValue<accountVAL[index])	
		{
		accountVAL[index]-=takeValue;
		}
		else
		{
			String warning=("Error: UNABLE TO WITHDRAW THAT AMOUNT");
			System.out.println(warning);
		//	throw EXCEPTION;
			JOptionPane popupError=new JOptionPane();
			popupError.showMessageDialog(null, warning,"ERROR", JOptionPane.ERROR_MESSAGE);
			//JDialog dialog=popupError.createDialog("ERROR");
			//dialog.show();
			Object selectedValue = popupError.getValue();
		    // if(selectedValue == null)
		    //   return CLOSED_OPTION;
			
			//accountVAL[index]=0.00;
			
			
		}
		
		
		
		
		ModelEvent me=new ModelEvent(this,index,"",accountVAL[index]);
		notifyChanged(me);
	}
	
	
	/**
	 * 
	 */
	public void save()
	{
		try{
			FileWriter ofstream=new FileWriter(saveFile);
			BufferedWriter out=new BufferedWriter(ofstream);
			
			int num=accountNAMElist.size();
			
			for(int i=0; i<num; i++)
			{
				out.write(accountNAME[i]+" ");
				out.write(accountNUM[i]+" ");
				out.write(accountVAL[i]+" ");
				out.newLine();
				
			}
			
			out.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{}
		
	}
	


}
