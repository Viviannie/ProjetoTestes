package model.excecoes;

public class RegraException extends Exception {

	public RegraException(){

	}

	public RegraException(String x){
		super(x);
	}

	public RegraException(String message, Throwable cause) {
		super(message, cause);
	}
}
