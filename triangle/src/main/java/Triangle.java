import org.apache.commons.lang3.math.NumberUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Triangle {
    public int getValue() {
        int value = 0;
        String side = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            do {

                side = br.readLine();
                if (!NumberUtils.isParsable(side)) {
                    System.err.println("Enter a number. Please enter a numbers within the range from 1 to MaxInteger (1000000000)");
                } else {
                    try {
                        value = Integer.parseInt(side);
                        if ((value < 1) || (value > 1000000000)) {
                            System.err.println("The number is out of the range. Please enter a numbers within the range from 1 to MaxInteger (1000000000)");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Enter an integer number. Please enter a numbers within the range from 1 to MaxInteger (1000000000)");
                    }
                }
            } while (true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }


    public boolean isTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public void triangleType(int a, int b, int c) {


        if (isTriangle(a, b, c)) {
            if (isTriangeEquileteral(a, b, c)) {
                System.out.println("\nEquilateral triangle with sides: a = " + a + "; b = " + b + "; c = " + c);
            } else if (isTriangleIsosceles(a, b, c)) {
                System.out.println("\nIsosceles triangle with sides: a = " + a + "; b = " + b + "; c = " + c);
            } else if (isTriangleScalene(a, b, c)) {
                System.out.println("\nScalene triangle with sides: a = " + a + "; b = " + b + "; c = " + c);
            }
        } else {
            System.err.println("\nNot a triangle");
        }
    }

    public boolean isTriangeEquileteral(int a, int b, int c) {
        return (a == b) & (a == c) & (b == c);
    }

    public boolean isTriangleIsosceles(int a, int b, int c) {
        return (a == b) || (a == c) || (b == c);
    }

    public boolean isTriangleScalene(int a, int b, int c) {
        return (a != b) & (a != c) & (b != c);
    }
}