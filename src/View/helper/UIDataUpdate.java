package View.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import Controller.Data;
import View.Workspace;
import View.tabs.VariablesPane;
import model.variable.Variable;

public class UIDataUpdate implements Observer {

	private Workspace wkspc;
	private VariablesPane varPane;

	public UIDataUpdate(Workspace wkspc) {
		this.wkspc = wkspc;
		Data.getInstance().addObserver(this);
	}

	public UIDataUpdate(Workspace wkspc, VariablesPane varPane) {
		this.wkspc = wkspc;
		this.varPane = varPane;
		Data.getInstance().addObserver(this);
	}

	public void checkForChange() {

	}
	
	private void addAllVarsToPane(Map<String, Variable> vars){
		vars = (HashMap<String, Variable>) vars;
		for (String key: vars.keySet()){
			varPane.addItem(key +" = "+vars.get(key).getValue());
		}
		
	}

	@Override
	public void update(Observable o, Object arg) {
		addAllVarsToPane((Map<String, Variable>)Data.getInstance().getVariables());
		wkspc.changeAnimalBackgroundColor(Data.getInstance().getBackgroundColor());
		
	}

}
