package com.allin.java.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
	
	public static void trackUseCases(List<Integer> useCases, Class<?> clazz){
		for (Method m : clazz.getDeclaredMethods()) {
			UseCase uc = m.getAnnotation(UseCase.class);
			if(uc != null){
				System.out.println("found use case: " + uc.id() + ", " + uc.description());
				useCases.remove(new Integer(uc.id()));
			}
		}
		
		for(int i : useCases){
			System.out.println("Warning: Missing use case " + i);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> useCases = new ArrayList<>();
		Collections.addAll(useCases, 1, 47, 48, 49, 50);
		trackUseCases(useCases, PasswordUtils.class);
	}

}
