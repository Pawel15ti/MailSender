package pl.ozdoba.pawel.mailsender;

public class SendeEmailExceptiona {
	public void mojWyjatek(){
		System.out.println("Wystąpił wyjątek");
		throw new SendeEmailExceptiona();
	}

}
