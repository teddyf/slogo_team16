package Parsing;

public class ExpressionTree {
    
    public final Expression ROOT = new Constant("ROOT",0);
    
    /**
     * Returns root of tree 
     * @param a
     * @return
     */
    public TreeNode buildTree(String[] a){
        TreeNode root = new TreeNode(ROOT);
        for(String str: a){
        }
        return root;
    }
    
    
    
}
