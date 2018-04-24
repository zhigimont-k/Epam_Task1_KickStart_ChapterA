package by.epam.task1.action;

import by.epam.task1.entity.Point;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PointActionTest {
    private PointAction action;

    @BeforeClass
    public void init(){
        action = new PointAction();
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData() {
        Point first = new Point(1, 2, 3);
        Point second = new Point(4, 5, 6);
        Point third = new Point(3, 0, 2);
        double distance1 = action.calculateDistance(first, second);
        distance1 = BigDecimal.valueOf(distance1).setScale(3, RoundingMode.HALF_UP).doubleValue();
        double distance2 = action.calculateDistance(second, third);
        distance2 = BigDecimal.valueOf(distance2).setScale(3, RoundingMode.HALF_UP).doubleValue();
        double distance3 = action.calculateDistance(first, third);
        distance3 = BigDecimal.valueOf(distance3).setScale(3, RoundingMode.HALF_UP).doubleValue();
        return new Object[][]{{distance1, 5.196}, {distance2, 6.481}, {distance3, 3}};
    }

    @Test(dataProvider = "dataProvider")
    public void calculateDistance(double distance, double expected) {
        Assert.assertEquals(distance, expected);
    }
}
