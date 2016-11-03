/**
 * This is the Expression class, which is a property of a tree node and determines what type the node is (command, bracket, 
 * variable, root, or constant)
 * 
 * @author Teddy Franceschi
 * @author Aninda Manocha
 */

package Parsing.expression;

import Parsing.TreeNode;
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
