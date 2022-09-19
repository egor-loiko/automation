import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleMain {
    public static void main(String[] args) {

        BufferedReader br = null;
        Triangle triangle = new Triangle();

        try {
            br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the first side");
            String a = br.readLine();
            System.out.println("The first side = " + a);

            System.out.println("Enter the second side: ");
            String b = br.readLine();
            System.out.println("The second side = " + b);

            System.out.println("Enter the third side: ");
            String c = br.readLine();
            System.out.println("The third side = " + c);

            System.out.println(triangle.setData(a, b, c).triangleType().getTriangleMessage());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }


    }
}
