package accountManager.model;
import java.awt.event.ActionEvent;

public class ModelEvent extends ActionEvent {

	private double amount;
	int id;

	
	
	public ModelEvent(Object obj, int id, String message, double amount)
	{
		
		
		super(obj, id, message);
		
		this.id=id;
		this.amount=amount;
	
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public int getId()
	{
		return id;
	}
	
	
}
