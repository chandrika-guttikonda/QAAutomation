package Day12_ExceptionHandling_DebuggingFailures;

public class BlankUsernameException extends Exception{
	public BlankUsernameException(String message) {
        super(message);
    }
}
