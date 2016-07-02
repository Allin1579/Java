package com.allin.java.annotation;

import java.util.List;

public class PasswordUtils {
	
	@UseCase(id = 47, description = 
		"password must contain one more numeric")
	public boolean validataPassword(String password){
		return password.matches("\\w*\\d\\w*");
	}
	
	@UseCase(id = 48)
	public String encryptPassword(String password) {
		return new StringBuilder(password).reverse().toString();
	}
	
	@UseCase(id = 49, description = 
		"New passwords can't equal previously used ones")
	public boolean checkForNewPassword(List<String> passwords, String password) {
		return !passwords.contains(password);
	}

}
