package by.epam.task1.matrix;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MatrixDeterminantCalculatorTest {

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(){
        MatrixDeterminantCalculator matrix = new MatrixDeterminantCalculator(new double[][]{{1, 2, 3}, {4, 5, 12}, {7, 18, 9}});
        double determinant1 = matrix.determinant();
        matrix = new MatrixDeterminantCalculator(new double[][]{{0, 2, 4}, {-4, 8, 2}, {1, 8, 19}});
        double determinant2 = matrix.determinant();
        return new Object[][]{{determinant1, 36}, {determinant2, -4}};
    }
    @Test(dataProvider = "dataProvider")
    public void determinant(double determinant, double expected){
        Assert.assertEquals(determinant, expected);
    }
}
