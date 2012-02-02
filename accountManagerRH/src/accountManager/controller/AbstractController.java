package accountManager.controller;

import accountManager.model.Model;
import accountManager.view.View;

public abstract class AbstractController implements Controller {
	
	private View view;
	private Model model;
	
	@Override
	public void setModel(Model model){this.model = model;}
	@Override
	public Model getModel() {return model;}
	
	@Override
	public void setView(View view){this.view=view;}
	@Override
	public View getView(){return view;}

}
