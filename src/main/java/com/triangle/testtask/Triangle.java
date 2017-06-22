package com.triangle.testtask;

import java.math.BigDecimal;

public class Triangle {
	
    public static TriangleType classify(double sideA, double sideB, double sideC) {
        if (invalidInputCheck(sideA, sideB, sideC)) {
            return TriangleType.INVALID;
        }
        
        if (sideA == sideB && sideB == sideC) {
            return TriangleType.EQUILATERAL;
        } else if (sideA == sideB || sideB == sideC) {
            return TriangleType.ISOSCELES;
        } else {
            return TriangleType.SCALENE;
        }
    }

    private static boolean invalidInputCheck(double sideA, double sideB, double sideC) {
        return ((sideA <= 0) || (sideB <= 0) || (sideC <= 0) ||
                Double.isNaN(sideA) || Double.isNaN(sideB) || Double.isNaN(sideC) ||
                Double.isInfinite(sideA) || Double.isInfinite(sideB) || Double.isInfinite(sideC) || 
                compareSumLess(sideA, sideB, sideC) || 
                compareSumLess(sideB, sideC, sideA) ||
                compareSumLess(sideC, sideA, sideB));
    }
    
    private static boolean compareSumLess(double a, double b, double c) {
    	return (new BigDecimal(a).add(new BigDecimal(b)).compareTo(new BigDecimal(c)) != 1);
    }
}
