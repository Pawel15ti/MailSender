package pl.ozdoba.pawel.mailsender;
/**
 * 
 * @author Pawcio
 *@param SendeEmailExceptiona() klasa ta jest to klasa wyjątku która zostaje wywołana podczas gdy wystapi błąd wysyłania maila
 */
public class SendeEmailExceptiona extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SendeEmailExceptiona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendeEmailExceptiona(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SendeEmailExceptiona(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SendeEmailExceptiona(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
