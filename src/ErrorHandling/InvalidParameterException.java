package ErrorHandling;

public class InvalidParameterException extends Exception{
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructs the Exception.
     * 
     * @param message Error message that is thrown.
     */
    public InvalidParameterException(String message) {
            super(message);
    }
}
