package by.epam.task1.reader;

import by.epam.task1.part1.action.TetrahedronAction;
import by.epam.task1.part1.entity.Point;
import by.epam.task1.part1.entity.Tetrahedron;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TetrahedronActionTest {
    private static Tetrahedron tetrahedron;

    @BeforeClass
    public static void initTetrahedron(){
        tetrahedron = new Tetrahedron(new Point(0, 1, 2), new Point(3, 3, 2),
                new Point(6, 1,4), new Point(9, 3, 2));
    }
    @Test
    public void calculateTriangleArea(){
        double area = TetrahedronAction.calculateTriangleArea(
                new Point(1, 3, 4),
                new Point(3, 4, 8),
                new Point(10, 11, 16));
        double expected = 12.18;
        area = BigDecimal.valueOf(area).setScale(2, RoundingMode.HALF_UP).doubleValue();
        Assert.assertEquals(area, expected);
    }

    @Test
    public void calculateSurfaceArea(){
        double expected = 32.49;
        double area = TetrahedronAction.calculateSurfaceArea(tetrahedron);
        area = BigDecimal.valueOf(area).setScale(2, RoundingMode.HALF_UP).doubleValue();
        Assert.assertEquals(area, expected);
    }

    @Test
    public void calculateVolume(){
        double expected = 4;
        double volume = TetrahedronAction.calculateVolume(tetrahedron);
        volume = BigDecimal.valueOf(volume).setScale(2, RoundingMode.HALF_UP).doubleValue();
        Assert.assertEquals(volume, expected);
    }
}
