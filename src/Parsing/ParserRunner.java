package Parsing;
import model.command.turtle.movement.Forward;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class ParserRunner {

    private ProgramParser parser;
    private String language;
    private List<Entry<String, Pattern>> methodPaths;

    private final String REGEX = "\\p{Space}|^#.*";
    private final String PATH = "resources/languages/";
    private final String PATH_SYNTAX = "resources/languages/Syntax";
    private final String METHOD = "run";
    private final String PARAM_COUNT = "paramCount";
    private final String RESOURCE_PATH = "resources/languages/methodMapping";

    File file = new File("Resources/myInput.slogo");

    public ParserRunner (String language, ProgramParser parser) {
        this.parser = parser;
        this.language = language;
        parser.setNames(PATH + language);
        parser.setLabels(PATH_SYNTAX);
        methodPaths = new ArrayList<>();
        addPatterns(RESOURCE_PATH);
    }

    private String[][] parseLine (ProgramParser lang, String input) {
        String[] text = input.split(REGEX);
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> symbols = new ArrayList<String>();
        // System.out.println(lang.mySymbolNames);
        for (int i = 0; i < text.length; i++) {

            String s = text[i];
            // System.out.println(s);
            if (s.trim().length() > 0) {
                // System.out.println(String.format("%s : %s : %s", s, lang.getName(s),
                // lang.getLabel(s)));
                if (isNumber(s)) {
                    names.add(s);
                }
                else if (isVariable(s)) {
                    names.add(s);
                }

                else if (s.equals("[") || s.equals("]")) {
                    names.add(s);
                }
                else if (s.equals("(") || s.equals(")")) {
                    names.add(s);
                }
                else if (isMethod(s) && lang.getName(s).equals("NO MATCH")) {
                    names.add(s);
                }
                else
                    names.add(lang.getName(s));
                symbols.add(lang.getLabel(s));
            }
        }
        ArrayList<String> combined = mergeSymbols(names, symbols);
        String[] sol1 = symbols.toArray(new String[symbols.size()]);
        String[] sol2 = names.toArray(new String[names.size()]);
        // String[] sol3 = combined.toArray(new String[combined.size()]);
        String[][] sol = { sol1, sol2 };
        return sol;
    }

    public String[][] combineAllLines () throws FileNotFoundException {
        Scanner in = new Scanner(file);
        ArrayList<String> nombres = new ArrayList<String>();
        ArrayList<String> types = new ArrayList<String>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[][] lineArray = parseLine(parser, line);
            for (int i = 0; i < lineArray[0].length; i++) {
                nombres.add(lineArray[1][i]);
                types.add(lineArray[0][i]);
            }
        }
        in.close();
        String[] sol1 = nombres.toArray(new String[nombres.size()]);
        String[] sol2 = types.toArray(new String[types.size()]);
        // System.out.println("am here");
        // for(int i = 0; i < sol1.length; i++) System.out.println(sol1[i]);
        ArrayList<String> combined = mergeSymbols(nombres, types);
        String[] sol3 = combined.toArray(new String[combined.size()]);
        String[][] sol = { sol1, sol2, sol3 };
        return sol;

    }

    public String[][] markDepth (String[][] input) throws NoSuchMethodException, SecurityException,
                                                   ClassNotFoundException, InstantiationException,
                                                   IllegalAccessException, IllegalArgumentException,
                                                   InvocationTargetException, NoSuchFieldException {
        ArrayList<String> userInput = new ArrayList<String>();
        ArrayList<String> vestigialLabels = new ArrayList<String>();
        Stack<Double> st = new Stack<Double>();
        for (int i = 0; i < input[0].length; i++) {
            String s = input[0][i];
            userInput.add(s);
            vestigialLabels.add(input[1][i]);
            if (isMethod(s)) {
                // System.out.println(s);
                double count = getCommandParamCount(s);
                // System.out.println(count);
                if (count > 0) {
                    st.push(count);
                    userInput.add("{");
                    vestigialLabels.add("{");
                }
            }
            else {
                if (!st.isEmpty()) {
                    double check = st.pop() - 1;
                    st.push(check);
                    if (st.peek() <= 0) {
                        st.pop();
                        userInput.add("}");
                        vestigialLabels.add("}");
                    }
                }
            }
        }
        for (int i = 0; i < st.size(); i++) {
            userInput.add("}");
        }
        String[] sol1 = userInput.toArray(new String[userInput.size()]);
        String[] sol2 = vestigialLabels.toArray(new String[vestigialLabels.size()]);
        String[][] sol = { sol1, sol2 };
        return sol;
    }

    private boolean isMethod (String input) {
        return parser.getLabel(input).equals("Command");
    }
    
    public String[][] parseWithGroups(String[][] input){
        String [][] output = input;
        int start = 0;
        ArrayList<String> data = new ArrayList<String>();
        ArrayList<String> labels = new ArrayList<String>();
        String[][] sol;
        boolean inGroup = false;
        for(int i = 0; i < input[0].length; i++){
            if(input[0][i].equals("(")){
                System.out.println(i);
                start = i;
                inGroup = true;
            }
            if(input[0][i].equals(")")){
                inGroup = false;
                System.out.println(data);
                data.add(input[0][i]);
                labels.add(input[1][i]);
                String[] input1 = data.toArray(new String[data.size()]);
                String[] input2 = labels.toArray(new String[labels.size()]);
                String[][] inputF = {input1, input2};
                sol = handleGroups(inputF);
                output = cutPasteArray(output,sol,start,i);
                
            }
            if(inGroup == true){
                //System.out.println(i);
                data.add(input[0][i]);
                labels.add(input[1][i]);
            }
        }
        return output;
    }
    
    public String[][] cutPasteArray(String[][] a, String[][] b, int start, int end){
        ArrayList<String> sol1 = new ArrayList<String>();
        ArrayList<String> sol2 = new ArrayList<String>();
        
        for(int i = 0; i < a[0].length; i++){
            if(i < start || i > end){
                sol1.add(a[0][i]);
                sol2.add(a[1][i]);
            }
        }
        for(int i = 0; i < b[0].length; i++){
            sol1.add(start+i,b[0][i]);
            sol2.add(start+i,b[1][i]);
        }
        System.out.println(sol1);
        System.out.println(sol2);
        String[] aSol1 = sol1.toArray(new String[sol1.size()]);
        String[] aSol2 = sol2.toArray(new String[sol2.size()]);
        String[][]sol = {aSol1,aSol2};
        return sol;
    }

    private ArrayList<String> mergeSymbols (ArrayList<String> a, ArrayList<String> b) {
        ArrayList<String> sol = new ArrayList<String>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals("NO MATCH")) {
                if (b.get(i).equals("Variable")) {
                    sol.add(a.get(i));
                }
                sol.add(i, b.get(i));
            }
            else {
                sol.add(i, a.get(i));
            }
        }
        return sol;
    }

    private boolean isNumber (String input) {
        try {
            double d = Double.parseDouble(input);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // Outdated method
    public Object getParameterCount (String method) throws InstantiationException,
                                                    IllegalAccessException,
                                                    IllegalArgumentException,
                                                    InvocationTargetException,
                                                    NoSuchMethodException, SecurityException,
                                                    ClassNotFoundException, NoSuchFieldException {
        try {
            System.out.println(method);
            Class a = Class.forName("model.command.turtle.movement." + method);
            Object count = a.getField(PARAM_COUNT);
            return count;
        }
        catch (Exception e) {
            return Double.POSITIVE_INFINITY;
        }

    }

    public void toString (String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

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

    private double getCommandParamCount (String input) {
        try {
            String inputWithPath = getLabel(input);
            Class c = Class.forName(inputWithPath);
            Object obj = c.newInstance();
            Field count = obj.getClass().getDeclaredField(PARAM_COUNT);
            count.setAccessible(true);
            return count.getDouble(obj);
        }

        catch (Exception e) {

            return Double.POSITIVE_INFINITY;
        }

    }

    private void stacksPush (Stack<Integer> lengthSt,
                             Stack<String> methodSt,
                             Stack<Double> paramSt,
                             Stack<Integer> refSt,
                             String[][] input,
                             int index) {
        String[][] subArray = subArray(index, input);
        lengthSt.push(groupLength(subArray));
        methodSt.push(nextMethodGroup(input));
        paramSt.push(getCommandParamCount(methodSt.peek()));
        refSt.push(index);
    }

    private void setupGroupHandling (Stack<Integer> refSt,
                                     Stack<String> methodSt,
                                     Stack<Integer> lengthSt,
                                     Stack<Double> paramSt,
                                     String[][] input) {
        refSt.push(0);
        methodSt.push(nextMethodGroup(input));
        lengthSt.push(groupLength(input));
        paramSt.push(getCommandParamCount(methodSt.peek()));
    }

    private void stacksPop (Stack<String> methodSt,
                            Stack<Integer> lengthSt,
                            Stack<Double> paramSt,
                            Stack<Integer> refSt) {
        methodSt.pop();
        lengthSt.pop();
        paramSt.pop();
        refSt.pop();
    }
    
    private void iterateGroup(Stack<String> methodSt,
                              Stack<Integer> lengthSt,
                              Stack<Double> paramSt,
                              Stack<Integer> refSt,
                              int index,
                              int paramCount,
                              String[][]input,
                              ArrayList<String> data){
        int remaining = lengthSt.peek() - paramCount - refSt.peek();
        String s = input[0][index];
        if (s.equals("(")) {
            stacksPush(lengthSt, methodSt, paramSt, refSt, input, index);
        }
        else if (s.equals(")")) {
            stacksPop(methodSt, lengthSt, paramSt, refSt);
        }
        else if (!isMethod(s) && remaining > 0) {

            if (remaining <= paramSt.peek()) {
                data.add(methodSt.peek());
                for (int i = 0; i < paramSt.peek(); i++) {
                    data.add(input[0][index + i]);
                    paramCount++;
                }
            }
            else {
                data.add(methodSt.peek());
                data.add(s);
                paramCount++;
            }
        }
        index++;
    }

    public String[][] handleGroups (String[][] input) {
        ArrayList<String> data = new ArrayList<String>();
        ArrayList<String> labels = new ArrayList<String>();
        Stack<Integer> lengthSt = new Stack<Integer>();
        Stack<String> methodSt = new Stack<String>();
        Stack<Double> paramSt = new Stack<Double>();
        Stack<Integer> refSt = new Stack<Integer>();
        setupGroupHandling(refSt,methodSt,lengthSt,paramSt,input);
        int index = 1;
        int paramCount = 0;
        while (!lengthSt.isEmpty() && index < input[0].length) {
            int remaining = lengthSt.peek() - paramCount - refSt.peek();
            String s = input[0][index];
            if (s.equals("(")) {
                stacksPush(lengthSt, methodSt, paramSt, refSt, input, index);
            }
            else if (s.equals(")")) {
                stacksPop(methodSt, lengthSt, paramSt, refSt);
            }
            else if (!isMethod(s) && remaining > 0) {

                if (remaining <= paramSt.peek()) {
                    data.add(methodSt.peek());
                    labels.add("Command");
                    for (int i = 0; i < paramSt.peek(); i++) {
                        data.add(input[0][index + i]);
                        labels.add(input[1][index + i]);
                        paramCount++;
                    }
                }
                else {
                    data.add(methodSt.peek());
                    labels.add("Command");
                    data.add(s);
                    labels.add(input[1][index]);
                    paramCount++;
                }
            }
            index++;
        }
        System.out.println(data);
        String[] sol1 = data.toArray(new String[data.size()]);
        String[] sol2 = labels.toArray(new String[labels.size()]);
        String[][] sol = {sol1,sol2};
        return sol;
    }

    private String nextMethodGroup (String[][] input) {
        for (int i = 0; i < input[0].length; i++) {
            if (isMethod(input[0][i])) {
                return input[0][i];
            }
        }
        return "not found";
    }

    private int groupLength (String[][] input) {
        Stack<String> inputSt = new Stack<String>();
        inputSt.push(input[0][0]);
        int index = 1;
        int numCount = 0;
        while (!inputSt.isEmpty() && index < input[0].length) {
            // System.out.println(input[0][index]);
            // System.out.println(inputSt);
            String s = input[0][index];
            if (s.equals("(")) {
                inputSt.push(s);
            }
            else if (s.equals(")")) {
                inputSt.pop();
                numCount++;
            }
            if (inputSt.size() < 2 && !isMethod(s)) {
                numCount++;
            }
            index++;
        }
        return numCount - 2;
    }

    private String[][] subArray (int index, String input[][]) {
        ArrayList<String> a = new ArrayList<String>();
        ArrayList<String> b = new ArrayList<String>();
        for (int i = index; i < input[0].length; i++) {
            a.add(input[0][i]);
            b.add(input[1][i]);
        }
        String[] sol1 = a.toArray(new String[a.size()]);
        String[] sol2 = b.toArray(new String[b.size()]);
        String[][] sol = { sol1, sol2 };
        return sol;
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

    private boolean isVariable (String input) {
        return parser.getLabel(input).equals("Variable");
    }
}