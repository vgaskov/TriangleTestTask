package com.triangle.testtask;

import java.util.Scanner;
import org.apache.log4j.Logger;

public class Main {

	public static void main(String[] args) {
		final Logger log = Logger.getLogger(Main.class);
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Welcome to the triangle challenge program, you may exit the program at any time by typing 'quit'");
			log.info("Started the program");
			final double sideA = getDoubleFromKeyboard(sc ,"Please insert sideA:");		
			final double sideB = getDoubleFromKeyboard(sc, "Please insert sideB:");
			final double sideC = getDoubleFromKeyboard(sc, "Please insert sideC:");
			
			System.out.println("Testing a triangle with the following side lengths: " + sideA + " " + sideB + " " + sideC);
			log.info("Testing a triangle with the following side lengths: " + sideA + " " + sideB + " " + sideC);
			
			TriangleType triangle = Triangle.classify(sideA, sideB, sideC);
			log.info("The classification result is " + triangle);
			
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
		} catch (TriangleException e) {
			System.out.println(e.getLocalizedMessage().toString());
			log.info(e.getLocalizedMessage().toString());
		} catch (Exception e) {
			System.out.println("ERROR OCCURED: " + e.getLocalizedMessage().toString());
			log.error("ERROR OCCURED, the stack trace is: ", e);
		} finally {
			log.info("The program is exited");
		}
	}
	
	private static double getDoubleFromKeyboard(Scanner sc, String message) throws TriangleException {
		while (true) {
			System.out.println(message);
			if (sc.hasNext("quit")) {
				throw new TriangleException("quit inserted, exiting the program");
			} else if (sc.hasNextDouble()) {
				return sc.nextDouble();
			} else {
				System.out.println("the given value is non-numeric");
				sc.nextLine();
			}
		}
    }
}