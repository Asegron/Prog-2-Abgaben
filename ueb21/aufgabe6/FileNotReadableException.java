
public class FileNotReadableException extends RuntimeException {
	private static final String MESSAGE = "Datei nicht lesbar";

	public FileNotReadableException() {
		super(MESSAGE);
	}
}
