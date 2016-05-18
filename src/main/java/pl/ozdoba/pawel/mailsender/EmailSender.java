package pl.ozdoba.pawel.mailsender;



import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

//install - tworzy plik wynikowy(jar i war) i instaluje biblioteke
//package
//clean
//javadoc:javadoc

/**
 * Klasa do wyslania mail tekstowych i html.
 * Klasa posiada pola prywatne:

 * @author Pawcio
 *
 */
public class EmailSender {

	private String serwerSMTP;
	private int port;
	private boolean ssl;
	private String username;
	private String password;
	private String from;
	
	/**
	 * 
	 * @param serwerSMTP -jest to adres poczty wychodzącej dla poczty
	 * @param port - zmienna przechowująca numer portu
	 * @param ssl - zmienna typu boolean przechowuje wartość logiczną określający czy typ zabezpieczenia SSL jest czy go nie ma
	 * @param username - typu łańcuchowego, to login do konta mailowego 
	 * @param password -typu łańcuchowego zmienna odpowiada za hasło do konta poczty
	 * @param from -zmienna typu łańcuchowego która określa od kogo dostaliśmy maila.
	 */

	public EmailSender(String serwerSMTP, int port, boolean ssl, String username, String password, String from) {

		/**
		 * @param public EmailSender() - konstruktor klasy
		 * Przypisujemy do zmiennych prywatnych wartości podane podczas Tworzenia obiektu.
		 */
		
		this.serwerSMTP = serwerSMTP;
		this.port = port;
		this.ssl = ssl;
		this.username = username;
		this.password = password;
		this.from = from;


	}

	/**
	 *  @param public void sendHtmlEmail(String to, String title, String content)- metoda ta słuzy do wysyłania email typu html
	 *  przyjmuje 3 parametry: 
	 * 
	 * 
	 * @param to
	 *            do kogo wyslamy mail
	 * @param title
	 *            tytul maila
	 * @param content
	 *            tresc html maila
	 *            
	 * @throws SendeEmailExceptiona
	 *             wyjatek wyrzucany gdy jest blad z wyslaniem mail
	 *             
	 */
	public void sendHtmlEmail(String to, String title, String content) throws SendeEmailExceptiona {
		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName(serwerSMTP);
			email.setSmtpPort(port);
			email.setAuthenticator(new DefaultAuthenticator(username, password));
			email.setSSLOnConnect(ssl);
			email.setFrom(from);
			email.setSubject(title);
			email.setHtmlMsg(content);
			email.addTo(to);
			email.send();
			/**
			 * @param send() metioda słuzaca do wysyłania maila
			 */
		} catch (EmailException e) {
			throw new SendeEmailExceptiona(e);
		}

	}
	/**
	 *  @param public void sendHtmlEmail(String to,String toRe, String title, String content)- metoda ta jest przeciązona wersją metody sendHtmlEmail()
	 *  róznica polega na tym ze ta metoda przyjmuje dodatkowy parametr :
	 *  
	 * @param 	email.addTo(toRe)- który odpowiada za wysłanie kopii maila do wybranego uzytkownika
	 *             
	 */

	public void sendHtmlEmail(String to,String toRe, String title, String content) throws SendeEmailExceptiona {
		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName(serwerSMTP);
			email.setSmtpPort(port);
			email.setAuthenticator(new DefaultAuthenticator(username, password));
			email.setSSLOnConnect(ssl);
			email.setFrom(from);
			email.setSubject(title);
			email.setHtmlMsg(content);
			email.addTo(toRe);
			email.addTo(to);
			email.send();
		} catch (EmailException e) {
			throw new SendeEmailExceptiona(e);
		}

	}
/**
 * @param sendTextEmail() metoda ta jest analogiczna do metody wyzej lecz odpowiada za wysyłanie email w formie tekstu.
 * @param to
 * @param toRe
 * @param title
 * @param content
 * @throws SendeEmailExceptiona
 */
	public void sendTextEmail(String to, String toRe, String title, String content) throws SendeEmailExceptiona {
		
		try {
			Email email = new SimpleEmail();
			email.setHostName(serwerSMTP);
			email.setSmtpPort(port);
			email.setAuthenticator(new DefaultAuthenticator(username, password));
			email.setSSLOnConnect(ssl);
			email.setFrom(from);
			email.addTo(toRe);
			email.setSubject(title);
			email.setMsg(content);
			email.addTo(to);
			email.send();
		} catch (EmailException e) {
			throw new SendeEmailExceptiona(e);
		}

	}

public void sendTextEmail(String to, String title, String content) throws SendeEmailExceptiona {
		
		try {
			Email email = new SimpleEmail();
			email.setHostName(serwerSMTP);
			email.setSmtpPort(port);
			email.setAuthenticator(new DefaultAuthenticator(username, password));
			email.setSSLOnConnect(ssl);
			email.setFrom(from);
			email.setSubject(title);
			email.setMsg(content);
			email.addTo(to);
			email.send();
		} catch (EmailException e) {
			throw new SendeEmailExceptiona(e);
		}

	}

	public static void main(String[] args) throws SendeEmailExceptiona {
		/**
		 * @param email to obiekt słuzacy do wysylania maili tekstowych.
		 */
		EmailSender email = new EmailSender("smtp.googlemail.com", 465, true, "pawelozdobajava@gmail.com", "init2016","pawelozdobajava@gmail.com");
		email.sendTextEmail("Pawelozdoba07@gmail.com","pawelozdobajava@gmail.com", "Test2","<!DOCTYPE html> <html><body><h1>To jest testowy tekst</h1> </body></html>");
		
		/**
		 * @param email1 to obiekt słuzacy do wysylania maili typu html.
		 */
		EmailSender email1 = new EmailSender("smtp.googlemail.com", 465, true, "pawelozdobajava@gmail.com", "init2016","pawelozdobajava@gmail.com");
		email1.sendHtmlEmail("Pawelozdoba07@gmail.com","pawelozdobajava@gmail.com", "Test1","<!DOCTYPE html> <html><body><h1>To jest HTML</h1> </body></html>");
	
		
		
	

		// EmailSender onetEmail=new EmailSender("smtp.poczta.onet.pl" , 465,
		// true, "", "", "");
		// onetEmail.sendHtmlEmail("", "Test1 z ONET", "<!DOCTYPE html>
		// <html><body><h1>To jest testowy email</h1> </body></html>");
		// onetEmail.sendHtmlEmail("", "Test1 z ONET", "<!DOCTYPE html>
		// <html><body><h1>To jest testowy email</h1>
		// </body></html>");,"Pawelo2@vp.pl"
	}

}
