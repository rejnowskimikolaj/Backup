package com.sda.rest.model;

public enum LOGIN_RESULT {
	SUCCESS,	// ok, logged in
	GENERAL_FAILURE, // server error
	WRONG_PASSWORD, 
	USER_DOES_NOT_EXIST // than register this account
}
