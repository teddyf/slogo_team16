package Parsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.*;


public class ParserRunner {

    private ProgramParser parser;
    private String language;

    private final String REGEX = "\\p{Space}|^#.*";
    private final String PATH = "resources/languages/";
    private final String PATH_SYNTAX = "resources/languages/Syntax";
    private final String METHOD = "run";

    File file = new File("data/examples/sample.logo");

    public ParserRunner (String language, ProgramParser parser) {
        this.parser = parser;
        this.language = language;
        parser.setNames(PATH + language);
        parser.setLabels(PATH_SYNTAX);
    }

    private String[] parseLine (ProgramParser lang, String input) {
        String[] text = input.split(REGEX);
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> symbols = new ArrayList<String>();
        // System.out.println(lang.mySymbolNames);
        for (int i = 0; i < text.length; i++) {
            String s = text[i];
            if (s.trim().length() > 0) {
                System.out.println(String.format("%s : %s : %s", s, lang.getName(s),
                                                 lang.getLabel(s)));
                if(isNumber(s)){
                    names.add(s);
                }
                else names.add(lang.getName(s));
                symbols.add(lang.getLabel(s));
            }
        }
        ArrayList<String> combined = mergeSymbols(names, symbols);
        return combined.toArray(new String[combined.size()]);
    }

    public String[] combineAllLines () throws FileNotFoundException {
        Scanner in = new Scanner(file);
        ArrayList<String> lines = new ArrayList<String>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] lineArray = parseLine(parser, line);
            for (String s : lineArray) {
                lines.add(s);
            }
        }
        in.close();
        return lines.toArray(new String[lines.size()]);
    }

    public String[] markDepth(String[] input) throws NoSuchMethodException, SecurityException, ClassNotFoundException {
        ArrayList<String> userInput = new ArrayList<String>();
        Stack<Integer> st = new Stack<Integer>();
        for(String s: input){
            userInput.add(s);
            if(isMethod(s)){
                int param = Class.forName(s).
                Method m = Class.forName(s).getMethod(METHOD);
                st.push(m.getParameterCount());
                userInput.add("{");
            }
            else{
                if(!st.isEmpty()){
                    int check = st.pop()-1;
                    st.push(check);
                    if(st.peek() == 0){
                        st.pop();
                        userInput.add("}");
                    }
                }
            }
        }
        for(int i = 0; i < st.size(); i++){
            userInput.add("}");
        }
        return userInput.toArray(new String[userInput.size()]);
    } 

    private boolean isMethod (String input) {
        return parser.getLabel(input).equals("Command");
    }

    private ArrayList<String> mergeSymbols (ArrayList<String> a, ArrayList<String> b) {
        ArrayList<String> sol = new ArrayList<String>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals("NO MATCH")) {
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
}
