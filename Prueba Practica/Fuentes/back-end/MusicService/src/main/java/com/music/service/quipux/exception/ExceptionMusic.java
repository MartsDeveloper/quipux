package com.music.service.quipux.exception;

import java.io.Serializable;

public class ExceptionMusic extends Exception implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionMusic(String message) {
	        super(message);
	    }

}
