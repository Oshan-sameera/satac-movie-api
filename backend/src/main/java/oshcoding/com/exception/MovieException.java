package oshcoding.com.exception;

import org.springframework.http.HttpStatus;

public class MovieException {
	   private final String message;
	    public final Throwable throwable;
	    private final HttpStatus httpStatus;
	    public MovieException(String message, Throwable throwable, HttpStatus httpStatus) {
	        this.message = message;
	        this.throwable = throwable;
	        this.httpStatus = httpStatus;
	    }
	    
	    public String getMessage() {
	        return message;
	    }

	    public Throwable getThrowable() {
	        return throwable;
	    }

	    public HttpStatus getHttpStatus() {
	        return httpStatus;
	    }

}
