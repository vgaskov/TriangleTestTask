package com.triangle.testtask;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try {
			final double sideA = getDoubleFromKeyboard("Please insert sideA:");		
			final double sideB = getDoubleFromKeyboard("Please insert sideB:");
			final double sideC = getDoubleFromKeyboard("Please insert sideC:");
			
			System.out.println("Testing a triangle with the following side lengths: " + sideA + " " + sideB + " " + sideC);
			switch (Triangle.classify(sideA, sideB, sideC)) {
			case EQUILATERAL:
				System.out.println("The triangle is EQUILATERAL");
				break;
			case ISOSCELES:
				System.out.println("The triangle is ISOSCELES");
				break;
			case SCALENE:
				System.out.println("The triangle is SCALENE");
				break;
			default:
				System.out.println("The given input data does not correspond to any triangle");
				break;
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getLocalizedMessage().toString());
		}
	}
	
	private static double getDoubleFromKeyboard(String message) throws IllegalArgumentException {    	
		System.out.println(message);
		try (Scanner sc = new Scanner(new InputStreamDecorator(System.in))) {
			if (sc.hasNextDouble()) {
				return sc.nextDouble();
			} else {
				throw new IllegalArgumentException("the given value is non-numeric");
			}
		}
    }
}