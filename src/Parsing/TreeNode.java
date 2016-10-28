package Parsing;
import java.util.*;
public class TreeNode {
    
    public Expression expression;
    public ArrayList<TreeNode> neighbors;
    public TreeNode parent;
    
    public TreeNode(){
        this.neighbors = new ArrayList<TreeNode>();
    }
    public TreeNode(Expression expression, TreeNode parent){
        this.parent = parent;
        this.expression = expression;
        this.neighbors = new ArrayList<TreeNode>();
        if (parent != null) {
        	parent.push(this);
        }
    }
    
    public void push(TreeNode a){
        this.neighbors.add(a);
    }
    
    public ArrayList<TreeNode> getNeighbors(){
        return this.neighbors;
    }
    
    public TreeNode getParent(){
        return parent;
    }
    
    public String toString(){
        return this.expression.toString();
    }
    
    public ArrayList<TreeNode> getChildren(){
        return this.neighbors;
    }
}
