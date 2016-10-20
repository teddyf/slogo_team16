package Parsing;
import java.util.*;
public class TreeNode {
    
    public Expression expression;
    public ArrayList<TreeNode> neighbors;
    public TreeNode parent;
    
    public TreeNode(Expression expression){
        this.parent = null;
        this.expression = expression;
        this.neighbors = new ArrayList<TreeNode>();
    }
    
    public void push(TreeNode a){
        this.neighbors.add(a);
    }
    
    public ArrayList<TreeNode> getNeighbors(){
        return this.neighbors;
    }
}
