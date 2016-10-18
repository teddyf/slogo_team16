package View.helper;

public class SLogoMath {
	public SLogoMath() {
		
	}
	
	public double sum(double expression1, double expression2) {
		return expression1 + expression2;
	}
	
	public double difference(double expression1, double expression2) {
		return Math.abs(expression1 - expression2);
	}
	
	public double product(double expression1, double expression2) {
		return expression1*expression2;
	} 
	
	public double quotient(double expression1, double expression2) {
		return expression1/expression2;
	}
	
	public double remainder(double expression1, double expression2) {
		return expression1 % expression2;
	}
	
	public double minus(double expression) {
		return expression*-1;
	}
	
	public double random(double max) {
		return Math.random()*max;
	}
	
	public double sin(double degrees) {
		return Math.sin(degrees*Math.PI/180);
	}
	
	public double cos(double degrees) {
		return Math.cos(degrees*Math.PI/180);
	}
	
	public double tan(double degrees) {
		return Math.tan(degrees*Math.PI/180);
	}
	
	public double atan(double degrees) {
		return Math.atan(degrees*Math.PI/180);
	}
	
	public double log(double expression) {
		return Math.log(expression);
	}
	
	public double pow(double base, double exponent) {
		return Math.pow(base, exponent);
	}
	
	public double pi() {
		return Math.PI;
	}
}