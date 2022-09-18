import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleTest {
    Triangle triangle = new Triangle();

    @Test
    public void test1(){

        Assert.assertEquals(triangle.setData("10", "10", "10").triangleType().getTriangleMessage(), "Equilateral triangle");
    }
}
