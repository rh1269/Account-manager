package accountManager.controller;

import accountManager.model.Model;
import accountManager.view.View;


public interface Controller {

	void setModel(Model model);
	void setView(View view);
	Model getModel();
	View getView();
	
}
