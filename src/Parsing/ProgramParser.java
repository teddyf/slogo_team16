package Parsing;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
public class ProgramParser {
    // "types" and the regular expression patterns that recognize those types
    // note, it is a list because order matters (some patterns may be more generic)
    public List<Entry<String, Pattern>> mySymbolNames;
    public List<Entry<String, Pattern>> mySymbolTypes;
    public ProgramParser () {
        mySymbolNames = new ArrayList<>();
        mySymbolTypes = new ArrayList<>();
    }
    // adds the given resource file to this language's recognized types
    public List<Entry<String, Pattern>> addPatterns (String syntax) {
        List<Entry<String, Pattern>> data = new ArrayList<>();
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = resources.getString(key);
            data.add(new SimpleEntry<>(key,
                           // THIS IS THE IMPORTANT LINE
                           Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
        return data;
    }
    // returns the language's type associated with the given text if one exists 
    public String getSymbol (String text) {
        final String ERROR = "NO MATCH";
        for (Entry<String, Pattern> e : mySymbolNames) {
            if (match(text, e.getValue())) {
                return e.getKey();
            }
        }
        //System.out.println(mySymbolNames);
        return ERROR;
    }
    
    public String getSymbolType (String text){
        final String ERROR = "NO MATCH";
        for (Entry<String, Pattern> e : mySymbolTypes) {
            if (match(text, e.getValue())) {
                return e.getKey();
            }
        }
        //System.out.println(mySymbolTypes);
        return ERROR;
    }
    
    
    // returns true if the given text matches the given regular expression pattern
    private boolean match (String text, Pattern regex) {
        // THIS IS THE KEY LINE
        return regex.matcher(text).matches();
    }
    
    public void setSymbols(String path){
        this.mySymbolNames = addPatterns(path);
    }
    
    public void setSyntax(String path){
        this.mySymbolTypes = addPatterns(path);
    }
    
}