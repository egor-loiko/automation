import org.apache.commons.lang3.math.NumberUtils;

public class Triangle {
    private int a;
    private int b;
    private int c;
    private String message;
    public final String EQUILATERAL = "Equilateral triangle";
    public final String ISOSCELES = "Isosceles triangle";
    public final String SCALENE = "Scalene triangle";
    public final String NOT_TRIANGLE = "Not a triangle. The length of sum of two sides should be more than the length of the third side";
    public final String NOT_NUMBER = "Enter a number. Please enter a numbers within the range from 1 to MaxInteger (1000000000)";
    public final String OUT_OF_RANGE = "The number is out of the range. Please enter a numbers within the range from 1 to MaxInteger (1000000000)";
    public final String NOT_INTEGER = "Enter an integer number. Please enter a numbers within the range from 1 to MaxInteger (1000000000)";

    public boolean isValuesCorrect(String sideA, String sideB, String sideC) {

        if (!NumberUtils.isParsable(sideA) || !NumberUtils.isParsable(sideB) || !NumberUtils.isParsable(sideC)) {
            this.message = NOT_NUMBER;
            return false;
        } else {
            try {
                int a = Integer.parseInt(sideA);
                int b = Integer.parseInt(sideB);
                int c = Integer.parseInt(sideC);
                if ((a < 1) || (a > 1000000000) || (b < 1) || (b > 1000000000) || (c < 1) || (c > 1000000000)) {
                    this.message = OUT_OF_RANGE;
                    return false;
                } else {
                    this.a = Integer.parseInt(sideA);
                    this.b = Integer.parseInt(sideB);
                    this.c = Integer.parseInt(sideC);
                }
            } catch (NumberFormatException e) {
                this.message = NOT_INTEGER;
                return false;
            }
        }
        return true;
    }

    public Triangle setData(String sideA, String sideB, String sideC) {
        if (isValuesCorrect(sideA, sideB, sideC))
            this.message = null;
        return this;
    }

    public boolean isTriangle() {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public Triangle triangleType() {
        if (this.message == null) {
            if (isTriangle()) {
                if (isTriangleEquilateral()) {
                    //System.out.println("\nEquilateral triangle with sides: a = " + a + "; b = " + b + "; c = " + c);
                    this.message = EQUILATERAL;
                } else if (isTriangleIsosceles()) {
                    //System.out.println("\nIsosceles triangle with sides: a = " + a + "; b = " + b + "; c = " + c);
                    this.message = ISOSCELES;
                } else if (isTriangleScalene()) {
                    //System.out.println("\nScalene triangle with sides: a = " + a + "; b = " + b + "; c = " + c);
                    this.message = SCALENE;
                }
            } else {
                //System.err.println("\nNot a triangle");
                this.message = NOT_TRIANGLE;
            }
        }
        return this;
    }

    public String getTriangleMessage() {
        return this.message;
    }

    public boolean isTriangleEquilateral() {
        return (a == b) & (a == c) & (b == c);
    }

    public boolean isTriangleIsosceles() {
        return (a == b) || (a == c) || (b == c);
    }

    public boolean isTriangleScalene() {
        return (a != b) & (a != c) & (b != c);
    }
}