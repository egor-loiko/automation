public class TriangleMain {
    public static void main(String[] args) {

        int a = 0;
        int b = 0;
        int c = 0;

        Triangle triangle = new Triangle();

        System.out.println("Enter the first side");
        a = triangle.getValue();
        System.out.println("The first side = " + a);

        System.out.println("Enter the second side: ");
        b = triangle.getValue();
        System.out.println("The second side = " + b);

        System.out.println("Enter the third side: ");
        c = triangle.getValue();
        System.out.println("The third side = " + c);

        triangle.triangleType(a, b, c);
    }
}
