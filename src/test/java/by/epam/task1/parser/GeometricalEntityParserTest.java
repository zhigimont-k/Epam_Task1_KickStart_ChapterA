package by.epam.task1.parser;

import by.epam.task1.entity.Point;
import by.epam.task1.entity.Tetrahedron;
import by.epam.task1.exception.IllegalFileInputException;
import by.epam.task1.parser.GeometricalEntityParser;
import by.epam.task1.reader.TextFileReader;
import by.epam.task1.store.TetrahedronStore;
import by.epam.task1.validation.LineValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class GeometricalEntityParserTest {
    private final static String FILE_PATH = "data/input.txt";

    @DataProvider(name = "dataProvider")
    public Object[][] provideData() throws IllegalFileInputException{
        TetrahedronStore expected = new TetrahedronStore();
        expected.add(new Tetrahedron(new Point(1.0, 2.0, 3.5), new Point(4.5, 12.2, 0),
                new Point(14.4, 15.5, 0), new Point(17.7, 18.8, 0)));

        List<String> lines = new TextFileReader().readFile(FILE_PATH);
        new LineValidator().validate(lines);
        TetrahedronStore store = new GeometricalEntityParser().parse(lines);
        return new Object[][]{{store, expected}};
    }

    @Test(dataProvider = "dataProvider")
    public void parse(TetrahedronStore store, TetrahedronStore expected) {
        Assert.assertEquals(store, expected);
    }
}
