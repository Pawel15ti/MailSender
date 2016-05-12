package pl.ozdoba.pawel.mailsender;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

//1+ powinan miec metode wysylajaca email HTML (do kogo,tresc,tytul)
//2+ Podczas tworzenia obiektu musimy podac dane uwierzytelniajce i serwera smtp, oraz nadawca  -> constructor
//3- Jesli wytsapi blad podczas wysylania ma wyrzucic wyjatek SendeEmailException(trzeba utworzyc a nastepnie przechiwic wyjatek bazowy)
//4-Przetstowac na dowlnymm serwisie poz google
//5+ Dodac do repozytorium githuba wersje skonczona(uwaga zmiana wersji w pom'ie z 0.0.1 - SNAPSHOT -> 1.0.0)
public class Sender {
	private static final String SMTP_SERVER="smtp.gmail.com";//Serwer poczty wychodzacej
	private static final int SMTP_PORT=465;//Port serwera poczty wychodz�cej 
	private static final boolean SMTP_SSL=true;
	private static final String USERNAME="pawelozdobajava@gmail.com";
	private static final String PASSWORD="init2016";
	private static String password;
	private static String username;
	private static String doKogo,odKogo,temat,trescMaila;
	private URL url;
	private static boolean dalej=true;
	public Sender() {
		
		
	}
public Sender(String doKogo, String temat, String trescMaila) {
	
		this.doKogo=doKogo;
		HtmlEmail email = new HtmlEmail();
		email.setHostName(SMTP_SERVER);
		try {
			email.addTo(doKogo);
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			email.setFrom("pawelozdobajava@gmail.com");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		email.setSubject(temat);
		
		
		try {
			url = new URL("http://www.ekomtech.kiev.ua/local/logo/cisco_logo.gif");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  String cid=null;
		try {
			cid = email.embed(url, "Cisco");
		} catch (EmailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  try {
			email.setHtmlMsg("<html>"+trescMaila+" "+cid+"\"></html>");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 // email.setTextMsg(trescMaila);
		  
		  
		email.setSmtpPort(SMTP_PORT);
		email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
		email.setSSLOnConnect(SMTP_SSL);
	
	
		//email.setMsg("This is a test mail ... :-)");
		
		try {
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public static void manu(){
	Scanner sc=new Scanner(System.in);
	System.out.println("Zaloguj sie na konto podając dane email");
	System.out.println("Podaj login email:");
	username=sc.nextLine();
	
	System.out.println("Podaj hasło:");
	password=sc.nextLine();
	dalej=false;
	
	if(username.equals(USERNAME)&&password.equals(PASSWORD)){
		System.out.println("Poprawne dane logowania ");
		dalej=true;
	}
	else {
		System.out.println("Niepoprawne dane logowania");
		dalej=false;
		
	}
}
	
	public static void main(String[] args) throws EmailException, MalformedURLException {
		
		Scanner sc=new Scanner(System.in);
		
		
		do{
			manu();
		
		}
		while(dalej==false);
		
		System.out.println("Podaj adres mailowy do kogo chcesz wysłać maila");
		doKogo=sc.nextLine();
		//System.out.println(doKogo);
		
		
		
		
		System.out.println("Podaj temat maila");
		temat=sc.nextLine();
		//System.out.println(temat);
		
		System.out.println("Podaj tresc maila");
		trescMaila=sc.nextLine();
		//System.out.println(trescMaila);
		Sender sender=new Sender(doKogo,temat,trescMaila);
		

		// nested exception is:
//		com.sun.mail.smtp.SMTPAddressFailedException: 554 5.7.1 
//		<pawelozdoba07@gmail.com>: Recipient address rejected: 
//			<Pawelo2@vp.pl> is not authorized to send messages from 
//			<pawelozdobajava@gmail.com>
//		at com.sun.mail.smtp.SMTPTransport.rcptT
		//wyslanie email typu html

	}
}
