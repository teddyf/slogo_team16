package ErrorHandling;

public class ClassUndefinedException extends Exception{
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructs the Exception.
     * 
     * @param message Error message that is thrown.
     */
    public ClassUndefinedException(String message) {
            super(message);
    }
}
