package Parsing;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import Controller.AnimalController;
import ErrorHandling.InvalidLabelException;
import model.command.ProcessCommand;
public class Tester {
    public static void main (String[] args) throws FileNotFoundException, NoSuchMethodException,
                                            SecurityException, ClassNotFoundException,
                                            InstantiationException, IllegalAccessException,
                                            IllegalArgumentException, InvocationTargetException,
                                            NoSuchFieldException, InvalidLabelException{
        ProgramParser lang = new ProgramParser();
        ParserRunner pr = new ParserRunner("English", lang);
        //System.out.println(lang.getLabels());
        //System.out.println(lang.getNames());
        String[][] a = pr.combineAllLines();
        //System.out.println(toString(a[0]));
        //System.out.println(toString(a[1]));
        String[][] b = pr.markDepth(a);
        //System.out.println(toString(b[0]));
        ExpressionTree tree = new ExpressionTree();
        tree.buildTree(b);
        System.out.println("****");
        ArrayList<TreeNode>node = tree.dfs();
        ProcessCommand pc = new ProcessCommand();
        //System.out.println(tree.reverse(node));
        ArrayList<TreeNode> inputs = tree.reverse(node);
        for(int i = 0; i < inputs.size(); i++) {
			System.out.println(inputs.get(i).expression.getClass().getName());
		}
        System.out.println("PRINTING");
        double v = pc.process(new AnimalController(), tree.reverse(node));
        System.out.println(v);
    }
    
    public static <a> String toString(a[] input){
        String temp = "";
        for(int i = 0; i < input.length-1; i++){
            temp+=input[i] + " ";
        }
        temp += input[input.length-1];
        return temp;
    }
}
