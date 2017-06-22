package com.triangle.testtask;

import static org.junit.Assert.*;
import org.junit.Test;

import com.triangle.testtask.Triangle;
import com.triangle.testtask.TriangleType;

public class TriangleTest {

	/* EQUILATERAL test cases */
	
	@Test
	public void testEquilateral_IntFormat() {
		assertEquals(TriangleType.EQUILATERAL, Triangle.classify(1, 1, 1));
	}
	
	@Test
	public void testEquilateral_FloatingPointFormat() {
		assertEquals(TriangleType.EQUILATERAL, Triangle.classify(1.1, 1.1, 1.1));
	}

	@Test
	public void testEquilateral_ExpFromat() {
		assertEquals(TriangleType.EQUILATERAL, Triangle.classify(2e10, 2e10, 2e10));
	}
	
	@Test
	public void testEquilateral_MixedFromat() {
		assertEquals(TriangleType.EQUILATERAL, Triangle.classify(2e2, 200, 200.0));
		assertEquals(TriangleType.EQUILATERAL, Triangle.classify(200.0, 2e2, 200));
		assertEquals(TriangleType.EQUILATERAL, Triangle.classify(200, 200.0, 2e2));
	}
	
	@Test
	public void testEquilateral_Min() {
		assertEquals(TriangleType.EQUILATERAL, Triangle.classify(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE));
	}	
	
	@Test
	public void testEquilateral_Max() {
		assertEquals(TriangleType.EQUILATERAL, Triangle.classify(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE));
	}
	
	@Test
	public void testEquilateral_MaxExponent() {
		assertEquals(TriangleType.EQUILATERAL, Triangle.classify(Double.MAX_EXPONENT, Double.MAX_EXPONENT, Double.MAX_EXPONENT));
	}
	
	/*  ISOSCELES test cases */
	
	@Test
	public void testIsosceles_IntFormat() {
		assertEquals(TriangleType.ISOSCELES, Triangle.classify(200, 200, 150));
		assertEquals(TriangleType.ISOSCELES, Triangle.classify(150, 200, 200));
		assertEquals(TriangleType.ISOSCELES, Triangle.classify(200, 150, 200));
	}
	
	@Test
	public void testIsosceles_FloatingPointFormat() {
		assertEquals(TriangleType.ISOSCELES, Triangle.classify(200.0, 200.0, 150.0));
		assertEquals(TriangleType.ISOSCELES, Triangle.classify(150.0, 200.0, 200.0));
		assertEquals(TriangleType.ISOSCELES, Triangle.classify(200.0, 150.0, 200.0));
	}
	
	@Test
	public void testIsosceles_ExpFormat() {
		assertEquals(TriangleType.ISOSCELES, Triangle.classify(2e2, 2e2, 1.5e2));
		assertEquals(TriangleType.ISOSCELES, Triangle.classify(1.5e2, 2e2, 2e2));
		assertEquals(TriangleType.ISOSCELES, Triangle.classify(2e2, 1.5e2, 2e2));
	}
	
	@Test
	public void testIsosceles_MixedFormat() {
		assertEquals(TriangleType.ISOSCELES, Triangle.classify(2e2, 200, 150.0));
		assertEquals(TriangleType.ISOSCELES, Triangle.classify(150.0, 2e2, 200));
		assertEquals(TriangleType.ISOSCELES, Triangle.classify(200, 150.0, 2e2));
	}

	@Test
	public void testIsosceles_MinMax() {
		assertEquals(TriangleType.ISOSCELES, Triangle.classify(Double.MAX_VALUE, Double.MAX_VALUE, Double.MIN_VALUE));
		assertEquals(TriangleType.ISOSCELES, Triangle.classify(Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE));
		assertEquals(TriangleType.ISOSCELES, Triangle.classify(Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE));
	}
	
	/* SCALENE test cases */

	@Test
	public void testScalene_IntFromat() {
		assertEquals(TriangleType.SCALENE, Triangle.classify(10, 15, 19));
		assertEquals(TriangleType.SCALENE, Triangle.classify(19, 10, 15));
		assertEquals(TriangleType.SCALENE, Triangle.classify(15, 19, 10));	
	}
		
	@Test
	public void testScalene_FloatingPointFromat() {
		assertEquals(TriangleType.SCALENE, Triangle.classify(100.1, 150.4, 190.3));
		assertEquals(TriangleType.SCALENE, Triangle.classify(190.3, 100.1, 150.4));
		assertEquals(TriangleType.SCALENE, Triangle.classify(150.4, 190.3, 100.1));
	}
	
	@Test
	public void testScalene_ExpFromat() {
		assertEquals(TriangleType.SCALENE, Triangle.classify(1e2, 1.5e2, 1.9e2));
		assertEquals(TriangleType.SCALENE, Triangle.classify(1.9e2, 1e2, 1.5e2));
		assertEquals(TriangleType.SCALENE, Triangle.classify(1.5e2, 1.9e2, 1e2));
	}
	
	@Test
	public void testScalene_MixedFromat() {
		assertEquals(TriangleType.SCALENE, Triangle.classify(101.1, 1e2, 200));
		assertEquals(TriangleType.SCALENE, Triangle.classify(101.1, 200, 1e2));
		assertEquals(TriangleType.SCALENE, Triangle.classify(1e2, 101.1, 200));
	}
	
	/* INVALID test cases */
	
	@Test
	public void testInvalid_IntFromat() {
		assertEquals(TriangleType.INVALID, Triangle.classify(10, 15, 29));
		assertEquals(TriangleType.INVALID, Triangle.classify(29, 10, 15));
		assertEquals(TriangleType.INVALID, Triangle.classify(15, 29, 10));	
	}
		
	@Test
	public void testInvalid_FloatingPointFromat() {
		assertEquals(TriangleType.INVALID, Triangle.classify(100.1, 150.4, 290.3));
		assertEquals(TriangleType.INVALID, Triangle.classify(290.3, 100.1, 150.4));
		assertEquals(TriangleType.INVALID, Triangle.classify(150.4, 290.3, 100.1));
	}
	
	@Test
	public void testInvalid_ExpFromat() {
		assertEquals(TriangleType.INVALID, Triangle.classify(1e2, 1.5e2, 1.9e3));
		assertEquals(TriangleType.INVALID, Triangle.classify(1.9e3, 1e2, 1.5e2));
		assertEquals(TriangleType.INVALID, Triangle.classify(1.5e2, 1.9e3, 1e2));
	}
	
	@Test
	public void testInvalid_MixedFormat() {
		assertEquals(TriangleType.INVALID, Triangle.classify(1, 1.5, 1e1));
		assertEquals(TriangleType.INVALID, Triangle.classify(1e1, 1.5, 1));
		assertEquals(TriangleType.INVALID, Triangle.classify(1e1, 1, 1.5));
	}
	
	@Test
	public void testInvalid_Zero() {
		assertEquals(TriangleType.INVALID, Triangle.classify(0, 1.5, 3.5));
		assertEquals(TriangleType.INVALID, Triangle.classify(3.5, 0, 1.1));
		assertEquals(TriangleType.INVALID, Triangle.classify(3.5, 1.1, 0));
	}
		
	@Test
	public void testInvalid_Negative() {
		assertEquals(TriangleType.INVALID, Triangle.classify(-1, 1.5, 3.5));
		assertEquals(TriangleType.INVALID, Triangle.classify(3.5, -1, 1.1));
		assertEquals(TriangleType.INVALID, Triangle.classify(3.5, 1.1, -1));
	}
	
	@Test
	public void testInvalid_SumEqualToSide() {
		assertEquals(TriangleType.INVALID, Triangle.classify(2.0, 1.5, 3.5));
		assertEquals(TriangleType.INVALID, Triangle.classify(3.5, 2.0, 1.5));
		assertEquals(TriangleType.INVALID, Triangle.classify(3.5, 1.5, 2.0));
	}
	
	@Test
	public void testInvalid_NaN() {
		assertEquals(TriangleType.INVALID, Triangle.classify(Double.NaN, 1.5, 3.5));
		assertEquals(TriangleType.INVALID, Triangle.classify(3.5, Double.NaN, 1.1));
		assertEquals(TriangleType.INVALID, Triangle.classify(3.5, 1.1, Double.NaN));
	}
	
	@Test
	public void testInvalid_PositiveInfinity() {
		assertEquals(TriangleType.INVALID, Triangle.classify(Double.POSITIVE_INFINITY, 1.5, 3.5));
		assertEquals(TriangleType.INVALID, Triangle.classify(3.5, Double.POSITIVE_INFINITY, 1.1));
		assertEquals(TriangleType.INVALID, Triangle.classify(3.5, 1.1, Double.POSITIVE_INFINITY));
	}
	
	@Test
	public void testInvalid_NegativeInfinity() {
		assertEquals(TriangleType.INVALID, Triangle.classify(Double.NEGATIVE_INFINITY, 1.5, 3.5));
		assertEquals(TriangleType.INVALID, Triangle.classify(3.5, Double.NEGATIVE_INFINITY, 1.1));
		assertEquals(TriangleType.INVALID, Triangle.classify(3.5, 1.1, Double.NEGATIVE_INFINITY));
	}
}
