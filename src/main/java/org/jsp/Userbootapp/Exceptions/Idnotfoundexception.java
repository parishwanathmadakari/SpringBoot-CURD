package org.jsp.Userbootapp.Exceptions;

public class Idnotfoundexception extends RuntimeException {
	
	@Override
	public String getMessage() {
		
		return "Id not found";
	}

}
