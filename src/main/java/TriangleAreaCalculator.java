public class TriangleAreaCalculator {
    public double calculateArea(double base, double height) {
        if (base <= 0) {
            throw new IllegalArgumentException("Base must be positive");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        return (base * height) / 2;
    }
}

