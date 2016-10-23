package Parsing;

public abstract class Expression {
    private String name;
    public Expression(String name){
        this.name = name;
    }
    
    public String toString(){
        return this.name;
    }
}
