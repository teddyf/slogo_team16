package model.command;

public class Tester {
	public static void main (String args[]) {
		Command backward = new NewCommand();
		System.out.println(backward.getNumParams());
	}
}