package com.triangle.testtask;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		double sideA, sideB, sideC;
		
		sideA = getDoubleFromKeyboard("Please insert sideA:");
		sideB = getDoubleFromKeyboard("Please insert sideB:");
		sideC = getDoubleFromKeyboard("Please insert sideC:");

		TriangleType triangle = Triangle.classify(sideA, sideB, sideC);
 
		switch (triangle) {
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
	}
	
    private static double getDoubleFromKeyboard(String message) {
        double inputValue = 0;
        boolean inputValueIsDouble = false;
        
    	while(!inputValueIsDouble) {    	
    		System.out.println(message);
    		@SuppressWarnings("resource")
    		Scanner sc = new Scanner(System.in);
    		if (sc.hasNextDouble()) {
    			inputValue = sc.nextDouble();
    			inputValueIsDouble = true;
    		} else {
    			System.out.println("The given value is non-numeric");
    		}
        }
    	return inputValue;
    }
}