package pl.ozdoba.pawel.mailsender;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Simple {
	
	private static final String SMTP_SERVER="smtp.googlemail.com";//Serwer poczty wychodzacej
	private static final int SMTP_PORT=465;//Port serwera poczty wychodz�cej 
	private static final boolean SMTP_SSL=true;
	private static final String USERNAME="pawelozdobajava@gmail.com";
	private static final String PASSWORD="init2016";
	
	public static void main(String[] args) throws EmailException {

		Email email = new SimpleEmail();
		email.setHostName(SMTP_SERVER);
		email.setSmtpPort(SMTP_PORT);
		email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
		email.setSSLOnConnect(SMTP_SSL);
		email.setFrom("pawelozdobajava@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("pawelozdobajava@gmail.com");
		email.send();
		
		//wyslanie email typu html

	}

}
