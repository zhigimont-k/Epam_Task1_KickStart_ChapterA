package by.epam.task1.action;

import by.epam.task1.entity.Point;
import by.epam.task1.entity.Tetrahedron;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TetrahedronActionTest {

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(Method method) {
        Object[][] result = null;
        TetrahedronAction action = new TetrahedronAction();
        if (method.getName().equals("calculateTriangleArea")) {
            double area = action.calculateTriangleArea(
                    new Point(1, 3, 4),
                    new Point(3, 4, 8),
                    new Point(10, 11, 16));
            double expected = 12.18;
            area = BigDecimal.valueOf(area).setScale(2, RoundingMode.HALF_UP).doubleValue();
            result = new Object[][]{{area, expected}};
        }
        if (method.getName().equals("isTetrahedron")) {
            Tetrahedron tetrahedron = new Tetrahedron(new Point(0, 0, 0), new Point(0, 0, 0),
                    new Point(1, 4, 2), new Point(404, 42, 13));
            boolean expected = false;
            boolean answer = action.isTetrahedron(tetrahedron);
            result = new Object[][]{{answer, expected}};
        }
        if (method.getName().equals("calculateSurfaceArea") || method.getName().equals("calculateVolume") ||
                method.getName().equals("isBasisCoordinatePlane") || method.getName().equals("calculateVolumeRatio")) {
            Tetrahedron tetrahedron = new Tetrahedron(new Point(0, 1, 4), new Point(3, 3, 2),
                    new Point(6, 1, 2), new Point(9, 3, 2));

            if (method.getName().equals("calculateSurfaceArea")) {
                double expected = 28.49;
                double area = action.calculateSurfaceArea(tetrahedron);
                area = BigDecimal.valueOf(area).setScale(2, RoundingMode.HALF_UP).doubleValue();
                result = new Object[][]{{area, expected}};
            }

            if (method.getName().equals("calculateVolume")) {
                double expected = 4;
                double volume = action.calculateVolume(tetrahedron);
                volume = BigDecimal.valueOf(volume).setScale(2, RoundingMode.HALF_UP).doubleValue();
                result = new Object[][]{{volume, expected}};
            }

            if (method.getName().equals("isBasisCoordinatePlane")) {
                boolean expected = false;
                boolean answer = action.isBasisOnCoordinatePlane(tetrahedron);
                result = new Object[][]{{answer, expected}};
            }

            if (method.getName().equals("calculateVolumeRatio")) {
                double expected = 0.02;
                double ratio = action.calculateVolumeRatio(tetrahedron);
                ratio = BigDecimal.valueOf(ratio).setScale(2, RoundingMode.HALF_UP).doubleValue();
                result = new Object[][]{{ratio, expected}};
            }
        }
        return result;
    }

    @Test(dataProvider = "dataProvider")
    public void calculateTriangleArea(double area, double expected) {
        Assert.assertEquals(area, expected);
    }

    @Test(dataProvider = "dataProvider")
    public void calculateSurfaceArea(double area, double expected) {
        Assert.assertEquals(area, expected);
    }

    @Test(dataProvider = "dataProvider")
    public void calculateVolume(double volume, double expected) {
        Assert.assertEquals(volume, expected);
    }

    @Test(dataProvider = "dataProvider")
    public void isBasisCoordinatePlane(boolean result, boolean expected) {
        Assert.assertEquals(result, expected);
    }

    @Test(dataProvider = "dataProvider")
    public void calculateVolumeRatio(double ratio, double expected) {
        Assert.assertEquals(ratio, expected);
    }

    @Test(dataProvider = "dataProvider")
    public void isTetrahedron(boolean result, boolean expected) {
        Assert.assertEquals(result, expected);
    }
}
