package slogo_team16;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class Console{
	private TextArea console;

	public Console(TextArea area) {
		this.console = area;
	}

	public void writeToConsole(String text){
		console.appendText(text);
	}

}