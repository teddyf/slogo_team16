package ErrorHandling;

public class InvalidLabelException extends Exception{
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructs the Exception.
     * 
     * @param message Error message that is thrown.
     */
    public InvalidLabelException(String message) {
            super(message);
    }
}
