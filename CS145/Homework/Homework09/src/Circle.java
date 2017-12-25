/**
 * Copyright (c) Joshua Nelson 2017
 */

/**
 * @author Joshua Nelson
 *
 */
public class Circle implements Shape {
	public static final double pi = 3.14159265;
	private final float r;

	public Circle(float radius) {
		r = radius;
	}

	@Override
	public double getArea() {
		return pi * Math.pow(r, 2);
	}

	@Override
	public String getType() {
		return "Circle";
	}
	
	@Override
	public String toString() {
		return String.format("%s of radius %f and area %f", getType(), r, getArea());
	}

}
