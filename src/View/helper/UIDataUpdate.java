package View.helper;

import java.util.Observable;
import java.util.Observer;

import Controller.Data;
import View.Workspace;

public class UIDataUpdate implements Observer{
	
	private Workspace wkspc;
	
	public UIDataUpdate(Workspace wkspc){
		this.wkspc = wkspc;
	}
	
	public void checkForChange(){
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if (Data.getInstance().hasChanged()){
			System.out.println("Color has changed");
			wkspc.changeAnimalBackgroundColor(Data.getInstance().getBackgroundColor());
		}
		
	}

}
