package by.epam.task1.reader;

import by.epam.task1.part1.entity.Point;
import by.epam.task1.part1.entity.Pyramid;
import by.epam.task1.part1.exception.IllegalFileInputException;
import by.epam.task1.part1.parser.GeometricalEntityParser;
import by.epam.task1.part1.reader.TextFileReader;
import by.epam.task1.part1.store.PyramidStore;
import by.epam.task1.part1.validation.LineValidator;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;

import static by.epam.task1.reader.TextFileReaderTest.FILE_PATH;

public class GeometricalEntityParserTest {
    private LineValidator validator;
    private TextFileReader reader;
    private GeometricalEntityParser parser;
    private PyramidStore expected;

    @Before
    public void init() {
        validator = new LineValidator();
        reader = new TextFileReader();
        parser = new GeometricalEntityParser();
        expected = new PyramidStore();
        expected.add(new Pyramid(new Point(1.0, 2.0, 3.5), new Point(4.5, 12.2, 13.3),
                new Point(14.4, 15.5, 16.6), new Point(17.7, 18.8, 19.9)));
        expected.add(new Pyramid(new Point(12.1, 11.3, 6.5), new Point(8.1, 2.0, 3.5),
                new Point(4.5, 12.2, 13.3), new Point(14.4, 15.5, 16.6)));
        expected.add(new Pyramid(new Point(7.3, 8.9, 4.2), new Point(3.1, 2.0, 3.5),
                new Point(4.5, 12.2, 13.3), new Point(14.4, 15.5, 16.6)));
    }

    @Test
    public void parse() throws IllegalFileInputException{
        ArrayList<String> lines = reader.readFile(FILE_PATH);
        validator.validate(lines);
        PyramidStore store = parser.parse(lines);
        Assert.assertEquals(store, expected);
    }
}
