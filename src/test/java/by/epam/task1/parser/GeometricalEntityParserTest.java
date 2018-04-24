package by.epam.task1.parser;

import by.epam.task1.entity.Point;
import by.epam.task1.entity.Tetrahedron;
import by.epam.task1.store.TetrahedronStore;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class GeometricalEntityParserTest {
    private static GeometricalEntityParser parser;

    @BeforeClass
    public void init() {
        parser = new GeometricalEntityParser();
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData() {
        TetrahedronStore expected = new TetrahedronStore();
        expected.add(new Tetrahedron(new Point(1.0, 2.0, 3.5), new Point(4.5, 12.2, 0),
                new Point(14.4, 15.5, 0), new Point(17.7, 18.8, 0)));

        List<String> list = new ArrayList<>();
        list.add("1.0 2.0 3.5 4.5 12.2 0 14.4 15.5 0 17.7 18.8 0");
        list.add("12.1 11.3 6.5 8.1 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        list.add("7.3 8.9 4.2 3.1 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        list.add("6.4 15.9 9.0 6.4 15.9 9.0 4.5 12.2 13.3 14.4 15.5 16.6");
        return new Object[][]{{parser.parse(list), expected}};
    }

    @Test(dataProvider = "dataProvider")
    public void parse(TetrahedronStore store, TetrahedronStore expected) {
        Assert.assertEquals(store, expected);
    }

}
