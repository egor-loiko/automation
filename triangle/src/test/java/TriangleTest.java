import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleTest {
    Triangle triangle = new Triangle();

    @DataProvider
    public Object[][] fullApplicationTestData() {
        return new Object[][]{
                {triangle.setData("*", "1", "1").triangleType().getTriangleMessage(), triangle.NOT_NUMBER},
                {triangle.setData("2", "1.55", "3").triangleType().getTriangleMessage(), triangle.NOT_INTEGER},
                {triangle.setData("0", "1", "1").triangleType().getTriangleMessage(), triangle.OUT_OF_RANGE},
                {triangle.setData("-1", "1", "1").triangleType().getTriangleMessage(), triangle.OUT_OF_RANGE},
                {triangle.setData("1000000001", "1", "1").triangleType().getTriangleMessage(), triangle.OUT_OF_RANGE},
                {triangle.setData("2", "1", "1").triangleType().getTriangleMessage(), triangle.NOT_TRIANGLE},
                {triangle.setData("1", "2", "3").triangleType().getTriangleMessage(), triangle.NOT_TRIANGLE},
                {triangle.setData("10", "10", "10").triangleType().getTriangleMessage(), triangle.EQUILATERAL},
                {triangle.setData("3", "3", "5").triangleType().getTriangleMessage(), triangle.ISOSCELES},
                {triangle.setData("2", "3", "4").triangleType().getTriangleMessage(), triangle.SCALENE}
        };
    }

    @DataProvider
    public Object[][] isTriangleMethodTestData() {
        return new Object[][]{
                {triangle.setData("1", "1", "1").isTriangle(), true},
                {triangle.setData("1", "2", "1").isTriangle(), false},
                {triangle.setData("1", "2", "S").isTriangle(), false},
                {triangle.setData("1", "-2", "2").isTriangle(), false},
        };
    }

    @DataProvider
    public Object[][] isValuesCorrectMethodTest() {
        return new Object[][]{
                {triangle.isValuesCorrect("1", "1", "1"), true},
                {triangle.isValuesCorrect("1", "1000000000", "1"), true},
                {triangle.isValuesCorrect("1", "2", "S"), false},
                {triangle.isValuesCorrect("1", "-2", "2"), false},
                {triangle.isValuesCorrect("0", "2", "2"), false},
                {triangle.isValuesCorrect("5", "2", "1000000001"), false},
        };
    }

    @DataProvider
    public Object[][] isTriangleEquilateralTestData() {
        return new Object[][]{
                {triangle.setData("1", "1", "1").isTriangleEquilateral(), true},
                {triangle.setData("5000", "5000", "5000").isTriangleEquilateral(), true},
                {triangle.setData("1", "2", "2").isTriangleEquilateral(), false},
                {triangle.setData("100000", "100000", "100001").isTriangleEquilateral(), false},
        };
    }

    @DataProvider
    public Object[][] isTriangleIsoscelesTestData() {
        return new Object[][]{
                {triangle.setData("1", "1", "1").isTriangleIsosceles(), true},
                {triangle.setData("5001", "5000", "5000").isTriangleIsosceles(), true},
                {triangle.setData("1", "2", "3").isTriangleIsosceles(), false},
                {triangle.setData("100000", "100002", "100001").isTriangleIsosceles(), false},
        };
    }

    @DataProvider
    public Object[][] isTriangleScaleneTestData() {
        return new Object[][]{
                {triangle.setData("2", "5", "4").isTriangleScalene(), true},
                {triangle.setData("5001", "10000", "5000").isTriangleScalene(), true},
                {triangle.setData("1", "2", "2").isTriangleScalene(), false},
                {triangle.setData("5", "5", "5").isTriangleScalene(), false},
        };
    }

    @Test(dataProvider = "fullApplicationTestData")
    public void fullTest(String actualResult, String expectedResult) {
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "isTriangleMethodTestData")
    public void isTriangleMethodTest(boolean actualResult, boolean expectedResult) {
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "isValuesCorrectMethodTest")
    public void isValuesCorrectMethodTest(boolean actualResult, boolean expectedResult) {
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "isTriangleEquilateralTestData")
    public void isTriangleEquilateralTest(boolean actualResult, boolean expectedResult) {
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "isTriangleIsoscelesTestData")
    public void isTriangleIsosceleslTest(boolean actualResult, boolean expectedResult) {
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "isTriangleScaleneTestData")
    public void isTriangleScaleneTest(boolean actualResult, boolean expectedResult) {
        Assert.assertEquals(actualResult, expectedResult);
    }
}
