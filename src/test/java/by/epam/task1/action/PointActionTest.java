package by.epam.task1.action;

import by.epam.task1.entity.Point;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PointActionTest {

    @DataProvider(name = "dataProvider")
    public Object[][] provideData() {
        Point first = new Point(1, 2, 3);
        Point second = new Point(4, 5, 6);
        double expected = 5.196;
        double distance = new PointAction().calculateDistance(first, second);
        distance = BigDecimal.valueOf(distance).setScale(3, RoundingMode.HALF_UP).doubleValue();
        return new Object[][]{{distance, expected}};
    }

    @Test(dataProvider = "dataProvider")
    public void calculateDistance(double distance, double expected) {
        Assert.assertEquals(distance, expected);
    }
}
