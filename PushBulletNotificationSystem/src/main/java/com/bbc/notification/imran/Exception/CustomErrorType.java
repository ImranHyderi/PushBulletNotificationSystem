package com.bbc.notification.imran.Exception;

import com.bbc.notification.imran.dto.UserDTO;

/**
 * Custom error class to create custom error messages
 *  
 * @author Imran Hyderi
 *
 */
public class CustomErrorType extends UserDTO {
	
	private String errorMessage;
	
	public CustomErrorType(final String errorMessage){
		this.errorMessage = errorMessage;
	}
	
	/**
	 * Gets the error message set in the CustomErrorType class.  
	 * @return An String error message
	 *
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

}
