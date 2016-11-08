/**
 * This is the class that builds the tree of expressions and builds tree nodes
 * 
 * @author Teddy Franceschi
 * @author Aninda Manocha
 */

package Parsing.expression;
import ErrorHandling.*;
import Parsing.TreeNode;
import View.helper.Coordinate;
import model.animal.Animal;
import model.command.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import Controller.Data;

/**
 * Masterpiece for Teddy Franceschi
 * @author Theodore Franceschi & Aninda Manocha
 *
 */
public class ExpressionTree {
        
    private static final ExpressionTree instance = new ExpressionTree();
    private final String PARAM_COUNT = "knownParams";
    private final String RESOURCE_PATH = "resources/languages/methodMapping";
    private final Expression ROOT = new RootExpression("root");
    private final String LEFT_BRACKET = "{";  
    private final String RIGHT_BRACKET = "}"; 
    private final String LEFT_BRACE = "[";
    private final String RIGHT_BRACE = "]";
    
    private TreeNode root;
    private List<Entry<String, Pattern>> methodPaths;
    private ExpressionFactory factory;
    private List<Coordinate> points;
    private String currentCommand;
    
    private ExpressionTree(){
        methodPaths = new ArrayList<>();
        factory = new ExpressionFactory();
        points = new ArrayList<Coordinate>();
        addPatterns(RESOURCE_PATH);
    }
    
    /**
     * 
     * Returns instance of Expression Tree only if there is an instance, otherwise it creates a new one
     * @return
     */
    public static ExpressionTree getInstance() {
        return instance;
    }
    
    /**
     * Returns root of tree that was built using user input a
     * 
     * @param a This array stores both the values parsed and their depths, but also the label types
     * for each value
     * @return
     * @throws ClassNotFoundException
     * @throws InvalidLabelException
     */
    public TreeNode buildTree (String[][] a) throws ClassNotFoundException, InvalidLabelException {
        root = new TreeNode(ROOT, null);
        TreeNode parent = root;
        TreeNode curr = root;
        for (int i = 0; i < a[0].length; i++) {
            String currInput = a[0][i];
            String currLabel = a[1][i];
            if(a[0][i].equals(LEFT_BRACKET)){
                parent = curr;
            }
            else if(a[0][i].equals(RIGHT_BRACKET)){
                parent = parent.getParent();
            }
            else if(a[0][i].equals(LEFT_BRACE)){ 
                curr = buildNode(parent,currInput,currLabel); 
                parent = curr;
            }
            else if(a[0][i].equals(RIGHT_BRACE)){
                parent = parent.getParent();
            }
            else{
                curr = buildNode(parent,currInput,currLabel); 
            }        
        }
        return root;
    }
    
    private Class<?> getCommand (String input) throws ClassNotFoundException {
        try{
            String inputWithPath = getLabel(input);
            Class<?> c = Class.forName(inputWithPath);
            return c;
        }
        catch(ClassNotFoundException e){
            return NewCommand.class;
        }
    }
    
    
    private TreeNode buildNode (TreeNode parent, String name, String label) throws ClassNotFoundException, InvalidLabelException {
        Object obj;
        if (label.equals("Command")) {
            obj = getCommand(name);
            System.out.println(obj);
        } else if (label.equals("Constant")) {
            obj = Double.parseDouble(name);
        } else if (label.equals("ListStart")){
            obj = 0;
        } else if (label.equals("Variable")) {
                obj = label;
        } else {
            throw new InvalidLabelException("Invalid user input");
        }
        Expression e = factory.getInfo(name, label, obj);
        return new TreeNode(e, parent);
    }
    
    /**
     * Performs Depth First Searh on the nodes and returns the pre-order of the tree
     * @return
     */
    public ArrayList<TreeNode> dfs(){
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
    }
    
    private void addPatterns (String syntax) {
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
        return regex.matcher(text).matches();
    }
    
    private String getLabel (String text) {
        final String ERROR = "NO MATCH";
        for (Entry<String, Pattern> e : methodPaths) {
            if (match(text, e.getValue())) {
                return e.getKey();
            }
        }
        return ERROR;
    }
    //Teddy worked on everything above this minus the singleton pattern
    //Aninda worked on everything below this minus the singleton pattern
    /**
     * Processes a tree node to determine what type of node it is and return a value
     * @param turtle - the turtle to run the command on
     * @param node - the tree node
     * @return the value from the tree node (either from a parameter or command)
     */
    public double process(Animal turtle, TreeNode node) {
        double value = 0;
        Expression nodeExpression = node.expression;
        value = nodeExpression.run(turtle, node);
        return value;
    }
    
    
    /***** CURRENT COMMAND *****/
    
    /**
     * Gets the user-defined command that is running
     * @return current command
     */
    public String getCurrentCommand() {
    	return currentCommand;
    }
    
    /**
     * Sets the user-defined command that is running
     * @param currentCommand - the new user-define command name
     */
    public void setCurrentCommand(String currentCommand) {
    	this.currentCommand = currentCommand;
    }
    
    /***** POINTS *****/
    
    /**
     * Changes the list of points to a specified list of points
     * @param points - the new list of points 
     */
    public void setPoints(List<Coordinate> points) {
        this.points = points;
    }
    
    /**
     * Adds a point to the list of points to be mapped (and animated)
     * @param coordinate - the new point
     */
    public void addPoint(Coordinate coordinate) {
        points.add(coordinate);
    }
}