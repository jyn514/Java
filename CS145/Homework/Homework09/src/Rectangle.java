
public class Rectangle implements Shape {
	float l, w;

	public Rectangle(float length, float width) {
		l = length;
		w = width;
	}

	@Override
	public double getArea() {
		return l*w;
	}
	
	@Override
	public String toString() {
		return String.format("%s of length %f, height %f, and area %f", getType(), l, w, getArea());
	}

	@Override
	public String getType() {
		return "Rectangle";
	}

}
