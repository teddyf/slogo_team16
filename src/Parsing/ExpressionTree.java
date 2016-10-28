package Parsing;

import ErrorHandling.*;
import model.animal.Animal;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class ExpressionTree {
	
	private static final ExpressionTree instance = new ExpressionTree();
    private final String PARAM_COUNT = "knownParams";
    private final String RESOURCE_PATH = "resources/languages/methodMapping";
    private Expression ROOT = new RootExpression("root");
    private TreeNode root = new TreeNode(ROOT, null);
    private List<Entry<String, Pattern>> methodPaths;
    private ExpressionFactory factory;
    //private Stack<Expression> expressions;

    private ExpressionTree(){
        methodPaths = new ArrayList<>();
        //expressions  = new Stack<Expression>();
        factory = new ExpressionFactory();
        addPatterns(RESOURCE_PATH);
    }
    
    public static ExpressionTree getInstance() {
    	return instance;
    }
    
    /**
     * Returns root of tree
     * 
     * @param a
     * @return
     * @throws ClassNotFoundException
     * @throws InvalidLabelException
     */
    public TreeNode buildTree (String[][] a) throws ClassNotFoundException, InvalidLabelException {
        TreeNode parent = root;
        TreeNode curr = root;

        for (int i = 0; i < a[0].length; i++) {
            System.out.println(a[0][i]);
            if(a[0][i].equals("{")){
                parent = curr;
            }
            else if(a[0][i].equals("}")){
                parent = parent.getParent();
            }
            else if(a[0][i].equals("[")){
                curr = buildNode(parent,a[0][i],a[1][i]); 
            }
            else if(a[0][i].equals("]")){
                parent = parent.getParent();
            }
            else{
                curr = buildNode(parent,a[0][i],a[1][i]); 
            }        
        }
        
        return root;
    }

    public Class<?> getCommand (String input) throws ClassNotFoundException {
        String inputWithPath = getLabel(input);
        //System.out.println(input);
        Class<?> c = Class.forName(inputWithPath);
        return c;
    }

    public int getParamCount (Class<?> c) throws NoSuchFieldException, SecurityException {
        Object obj = c.getField(PARAM_COUNT);
        return (int) obj;
    }

    public TreeNode buildNode (TreeNode parent, String name, String label) throws ClassNotFoundException, InvalidLabelException {
        Object obj;
        if (label.equals("Command")) {
            obj = getCommand(name);
        }
        else if (label.equals("Constant")) {
            obj = Double.parseDouble(name);
        }
        
        else if (label.equals("ListStart")){
            obj = 0;
        }
        else {
            throw new InvalidLabelException("Invalid user input");
        }
        Expression e = factory.getInfo(name, label, obj);
        //System.out.println(label);
        return new TreeNode(e, parent);
    }
    
    /*public ArrayList<TreeNode> dfs(){
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        ArrayList<TreeNode> data = new ArrayList<TreeNode>();
        
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            if(!temp.equals(null)){
                data.add(temp);
                
            }
            System.out.println(temp.neighbors);
            for(TreeNode tn: temp.getNeighbors()){
                st.push(tn);
            }
            
        }
        data.remove(0);
        return data;
    }*/
    
    
    public void addPatterns (String syntax) {
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = resources.getString(key);
            methodPaths.add(new SimpleEntry<>(key,
                           // THIS IS THE IMPORTANT LINE
                           Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
    }
    
    private boolean match (String text, Pattern regex) {
        // THIS IS THE KEY LINE
        return regex.matcher(text).matches();
    }
    
    public String getLabel (String text) {
        final String ERROR = "NO MATCH";
        for (Entry<String, Pattern> e : methodPaths) {
            if (match(text, e.getValue())) {
                return e.getKey();
            }
        }
        return ERROR;
    }
    
    /*public ArrayList<TreeNode> reverse(ArrayList<TreeNode> a){
        ArrayList<TreeNode> rev = new ArrayList<TreeNode>();
        for(int i = a.size()-1; i >= 0; i--){
            rev.add(a.get(i));
        }
        return rev;
    }*/
    
    public double process(Animal turtle, TreeNode node) {
    	double value = 0;
    	Expression nodeExpression = node.expression;
    	value = nodeExpression.run(turtle, node);
    	return value;
    }
}


