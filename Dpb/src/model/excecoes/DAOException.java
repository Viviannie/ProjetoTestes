package model.excecoes;

public class DAOException extends Exception {

	public DAOException() {
    }

    public DAOException(String x) {
        super(x);
    }

    public DAOException(Exception e) {
        super(e);
    }
    
    public DAOException(String message, Throwable cause) {
    	super(message, cause);
    }
}
