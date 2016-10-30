package Parsing;

import java.util.List;
import java.util.Map;

import View.helper.Coordinate;
import model.animal.Animal;

public abstract class Expression {
    private String name;
    public Expression(String name){
        this.name = name;
    }
    
    public String toString(){
        return this.name;
    }
    
    public abstract double run(Animal turtle, TreeNode node);
}
