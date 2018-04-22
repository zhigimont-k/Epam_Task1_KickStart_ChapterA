package by.epam.task1.reader;

import by.epam.task1.part1.action.PointAction;
import by.epam.task1.part1.entity.Point;
import org.junit.Test;
import org.testng.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PointActionTest {

    @Test
    public void calculateDistance(){
        Point first = new Point(1, 2, 3);
        Point second = new Point(4, 5, 6);
        double expected = 5.196;
        double distance = PointAction.calculateDistance(first, second);
        distance = BigDecimal.valueOf(distance).setScale(3, RoundingMode.HALF_UP).doubleValue();
        Assert.assertEquals(distance, expected);
    }
}
