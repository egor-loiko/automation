import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class Triangle {
    private int a;
    private int b;
    private int c;
    private String message;

    public boolean isValuesCorrect(String sideA, String sideB, String sideC) {

        if (!NumberUtils.isParsable(sideA) || !NumberUtils.isParsable(sideB) || !NumberUtils.isParsable(sideC)) {
            this.message = "Enter a number. Please enter a numbers within the range from 1 to MaxInteger (1000000000)";
            return false;
        } else {
            try {
                int a = Integer.parseInt(sideA);
                int b = Integer.parseInt(sideB);
                int c = Integer.parseInt(sideC);
                if ((a < 1) || (a > 1000000000) || (b < 1) || (b > 1000000000) || (c < 1) || (c > 1000000000)) {
                    this.message = "The number is out of the range. Please enter a numbers within the range from 1 to MaxInteger (1000000000)";
                    return false;
                } else {
                    this.a = Integer.parseInt(sideA);
                    this.b = Integer.parseInt(sideB);
                    this.c = Integer.parseInt(sideC);
                }
            } catch (NumberFormatException e) {
                this.message = "Enter an integer number. Please enter a numbers within the range from 1 to MaxInteger (1000000000)";
                return false;
            }
        }


        return true;
    }

    public Triangle setData(String sideA, String sideB, String sideC) {
        isValuesCorrect(sideA, sideB, sideC);
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
                    this.message = "Equilateral triangle";
                } else if (isTriangleIsosceles()) {
                    //System.out.println("\nIsosceles triangle with sides: a = " + a + "; b = " + b + "; c = " + c);
                    this.message = "Isosceles triangle";
                } else if (isTriangleScalene()) {
                    //System.out.println("\nScalene triangle with sides: a = " + a + "; b = " + b + "; c = " + c);
                    this.message = "Scalene triangle";
                }
            } else {
                //System.err.println("\nNot a triangle");
                this.message = "Not a triangle";
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