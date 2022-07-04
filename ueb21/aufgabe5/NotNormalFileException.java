
public class NotNormalFileException extends RuntimeException {
	private static final String MESSAGE = "Keine normale Datei";
	
	public NotNormalFileException() {
		super(MESSAGE);
	}
}
