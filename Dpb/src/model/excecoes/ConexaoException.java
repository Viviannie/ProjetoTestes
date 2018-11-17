package model.excecoes;

public class ConexaoException extends Exception{

	public ConexaoException() {
	}

	public ConexaoException(String x) {
		super(x);                           
	}

	public ConexaoException(Exception e) {
		super(e);                          
	}

	public ConexaoException(String message, Throwable cause) {
		super(message, cause);
	}
}
