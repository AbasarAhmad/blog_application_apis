package com.saar.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	// we are going to make a unchecked construnctor
	
	String resourceName;
	String fieldName;
	long fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName,long fieldValue)
	{
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
		this.resourceName=resourceName;
		this.fieldName=fieldName;
		this.fieldValue=fieldValue;
	}

}
