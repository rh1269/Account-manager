package accountManager.model;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import accountManager.controller.AccountsController;

/**
 * 
 * @author Robert Humble, rh1269@txstate.edu
 *
 */
public class HWMAIN {

	/**
	 * 
	 * @param args
	 */
	public static void main(String [] args){
		
		
		
		  String file=args[0];
		 //String file="datab.txt.txt";
		
		 //int accountNUM[];
		 //double accountVAL[];
		 //String accountNAME[];
		
		
		 ArrayList<String> accountNAMElist=new ArrayList();
		 ArrayList<Double> accountVALlist=new ArrayList();
		 ArrayList<Integer> accountNUMlist=new ArrayList();
		 
		 
		
		
		
		try
		{
		//FileOutputStream out=new FileOutputStream("accountshw.txt");
		
		FileInputStream fstream =  new FileInputStream(file);
		
	   
		 
		
		   
		   //System.out.println(System.getProperty("user.dir"));
		   //File file=new File("datab");
		   
		   //System.out.println(file.exists());
		   
		   //BufferedReader inline= new BufferedReader(new FileReader(file));
		   DataInputStream in = new DataInputStream(fstream);
		   BufferedReader inline= new BufferedReader(new InputStreamReader(in));
		   
		   StringBuilder sb = new StringBuilder();
		   
		   String fullLine=" ";
		   String name;
		   int account;
		   double val;
		   
		   
		   while((fullLine=inline.readLine())!=null)
		   {
			  
			   
			   Scanner scan=new Scanner(fullLine);
			   name= scan.next();
			   account= scan.nextInt();
			   val= scan.nextDouble();
			   
			   System.out.println(name+account+val);
			   
			   accountNAMElist.add(name);
			   accountVALlist.add(val);
			   accountNUMlist.add(account);
			   scan.close();
			   
			   
			   
		   }
		   
		
		    fstream.close();
	   }
	   catch(IOException ex)
	   {
		   ex.fillInStackTrace();
		System.out.println(ex.getMessage());   
	   }
		
	  
	   
	   
	 new AccountsController(accountNAMElist,accountNUMlist,accountVALlist,file);}
		//new AccountsController();}
	
}
