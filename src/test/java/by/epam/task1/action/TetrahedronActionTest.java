package by.epam.task1.action;

import by.epam.task1.entity.Point;
import by.epam.task1.entity.Tetrahedron;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TetrahedronActionTest {
    private TetrahedronAction action;

    @BeforeClass
    public void init() {
        action = new TetrahedronAction();
    }

    @DataProvider(name = "triangleDataProvider")
    public Object[][] provideData() {
        double area1 = action.calculateTriangleArea(
                new Point(1, 3, 4),
                new Point(3, 4, 8),
                new Point(10, 11, 16));
        area1 = BigDecimal.valueOf(area1).setScale(2, RoundingMode.HALF_UP).doubleValue();

        double area2 = action.calculateTriangleArea(
                new Point(7, 3, 4),
                new Point(3, 2, 8),
                new Point(10, 8, 16));
        area2 = BigDecimal.valueOf(area2).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return new Object[][]{{area1, 12.18}, {area2, 35.05}};
    }

    @DataProvider(name = "tetrahedronDataProvider")
    public Object[][] provideData(Method method) {
        Object[][] result = null;
        Tetrahedron first = new Tetrahedron(new Point(0, 1, 4), new Point(3, 3, 2),
                new Point(6, 1, 2), new Point(9, 3, 2));
        Tetrahedron second = new Tetrahedron(new Point(0, 0, 15), new Point(0, 2, 5),
                new Point(1, 4, 5), new Point(4, 2, 5));
        if (method.getName().equals("checkTetrahedron")) {
            result = new Object[][]{{action.checkTetrahedron(first), true}, {action.checkTetrahedron(second), true}};
        }
        if (method.getName().equals("calculateSurfaceArea")) {
            double area1 = action.calculateSurfaceArea(first);
            area1 = BigDecimal.valueOf(area1).setScale(2, RoundingMode.HALF_UP).doubleValue();
            double area2 = action.calculateSurfaceArea(second);
            area2 = BigDecimal.valueOf(area2).setScale(2, RoundingMode.HALF_UP).doubleValue();
            result = new Object[][]{{area1, 28.49}, {area2, 54.96}};
        }

        if (method.getName().equals("calculateVolume")) {
            double volume1 = action.calculateVolume(first);
            volume1 = BigDecimal.valueOf(volume1).setScale(2, RoundingMode.HALF_UP).doubleValue();
            double volume2 = action.calculateVolume(second);
            volume2 = BigDecimal.valueOf(volume2).setScale(2, RoundingMode.HALF_UP).doubleValue();
            result = new Object[][]{{volume1, 4}, {volume2, 13.33}};
        }

        if (method.getName().equals("checkBasisOnCoordinatePlane")) {
            result = new Object[][]{{action.checkBasisOnCoordinatePlane(first), false},
                    {action.checkBasisOnCoordinatePlane(second), false}};
        }

        if (method.getName().equals("calculateVolumeRatio")) {
            double ratio1 = action.calculateVolumeRatio(first);
            ratio1 = BigDecimal.valueOf(ratio1).setScale(2, RoundingMode.HALF_UP).doubleValue();
            double ratio2 = action.calculateVolumeRatio(second);
            ratio2 = BigDecimal.valueOf(ratio2).setScale(2, RoundingMode.HALF_UP).doubleValue();
            result = new Object[][]{{ratio1, 0.02}, {ratio2, 0}};
        }
        if (method.getName().equals("checkBasisParallelOx")) {
            result = new Object[][]{{action.checkBasisParallelOx(first), false}, {action.checkBasisParallelOx(second), false}};
        }
        if (method.getName().equals("checkBasisParallelOy")) {
            result = new Object[][]{{action.checkBasisParallelOy(first), false}, {action.checkBasisParallelOy(second), false}};
        }
        if (method.getName().equals("checkBasisParallelOz")) {
            result = new Object[][]{{action.checkBasisParallelOz(first), true}, {action.checkBasisParallelOz(second), true}};
        }
        return result;
    }

    @Test(dataProvider = "triangleDataProvider")
    public void calculateTriangleArea(double area, double expected) { Assert.assertEquals(area, expected); }

    @Test(dataProvider = "tetrahedronDataProvider")
    public void calculateSurfaceArea(double area, double expected) {
        Assert.assertEquals(area, expected);
    }

    @Test(dataProvider = "tetrahedronDataProvider")
    public void calculateVolume(double volume, double expected) {
        Assert.assertEquals(volume, expected);
    }

    @Test(dataProvider = "tetrahedronDataProvider")
    public void checkBasisOnCoordinatePlane(boolean result, boolean expected) {
        Assert.assertEquals(result, expected);
    }

    @Test(dataProvider = "tetrahedronDataProvider")
    public void calculateVolumeRatio(double ratio, double expected) {
        Assert.assertEquals(ratio, expected);
    }

    @Test(dataProvider = "tetrahedronDataProvider")
    public void checkTetrahedron(boolean result, boolean expected) {
        Assert.assertEquals(result, expected);
    }

    @Test(dataProvider = "tetrahedronDataProvider")
    public void checkBasisParallelOx(boolean result, boolean expected) {
        Assert.assertEquals(result, expected);
    }

    @Test(dataProvider = "tetrahedronDataProvider")
    public void checkBasisParallelOy(boolean result, boolean expected) {
        Assert.assertEquals(result, expected);
    }

    @Test(dataProvider = "tetrahedronDataProvider")
    public void checkBasisParallelOz(boolean result, boolean expected) {
        Assert.assertEquals(result, expected);
    }
}
