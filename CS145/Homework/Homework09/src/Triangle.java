
public class Triangle implements Shape {
	float b, h;

	public Triangle(float base, float height) {
		b = base;
		h = height;
	}

	@Override
	public double getArea() {
		return b * h / 2;
	}

	@Override
	public String getType() {
		return "Triangle";
	}
	
	public String toString() {
		return String.format("%s of base %f,  height %f, and area %f", getType(), b, h, getArea());
	}

}
