package Parsing;
import java.io.FileNotFoundException;
import java.util.*;
public class Tester {
    public static void main(String[] args) throws FileNotFoundException, NoSuchMethodException, SecurityException, ClassNotFoundException{
        ProgramParser lang = new ProgramParser();
        ParserRunner pr = new ParserRunner("English", lang);
        String[] a = pr.combineAllLines();
        System.out.println(toString(a));
        String[] b = pr.markDepth(a);
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
