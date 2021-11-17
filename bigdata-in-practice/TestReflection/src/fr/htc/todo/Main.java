package fr.htc.todo;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		User user = new  User(100, "dmouchene", "passeDmouchene");
		for (Field field : User.class.getDeclaredFields()) {
			System.out.println(field.getName() + " | " + field.getType());
		}

	}
}
