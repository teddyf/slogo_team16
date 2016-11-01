package View.helper;

import java.util.HashSet;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import Controller.Data;
import View.Workspace;
import View.tabs.VariablesPane;
import model.variable.Variable;

public class UIDataUpdate implements Observer {

	private Workspace wkspc;
	private VariablesPane varPane;
	// private Map<String, Integer> variablesMap;
	private Set<String> variablesSet;

	public UIDataUpdate(Workspace wkspc) {
		this.wkspc = wkspc;
		Data.getInstance().addObserver(this);
	}

	public UIDataUpdate(Workspace wkspc, VariablesPane varPane) {
		this.wkspc = wkspc;
		this.varPane = varPane;
		this.variablesSet = new HashSet<>();
		// this.variablesMap = new HashMap<>();
		Data.getInstance().addObserver(this);
	}

	public void checkForChange() {

	}

	private void addAllVarsToPane(Map<String, Variable> vars) {
		// vars = (HashMap<String, Variable>) vars;
		// key is ":var"
		// varSet contains "var"
		for (String key : vars.keySet()) {
			if (variablesSet.contains(key.substring(1))) {
				for(int i = 0; i < varPane.getAllItems().size(); i++) {
//					if((varPane.getAllItems().get(i).charAt(0) .equals(key.charAt(1))) {
					String[] split = varPane.getAllItems().get(i).split("=");
					String var = split[0].trim();
					if(var.equals(key.substring(1))) {
						varPane.getAllItems().remove(i);
					}
//					}
				}
//				varPane.getAllItems().remove(key.substring(1) + " = " + vars.get(key).getValue());
			} else {
				variablesSet.add(key.substring(1));
			}
			// variablesMap.put(key, value)
			varPane.addItem(key.substring(1) + " = " + vars.get(key).getValue());
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		addAllVarsToPane(Data.getInstance().getVariables());
		wkspc.changeAnimalBackgroundColor(Data.getInstance().getBackgroundColor());

	}

//	public Map<String, Integer> getVariablesMap() {
//		return variablesMap;
//	}

}
