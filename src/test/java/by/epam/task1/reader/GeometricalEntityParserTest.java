package by.epam.task1.reader;

import by.epam.task1.part1.entity.Point;
import by.epam.task1.part1.entity.Tetrahedron;
import by.epam.task1.part1.exception.IllegalFileInputException;
import by.epam.task1.part1.parser.GeometricalEntityParser;
import by.epam.task1.part1.reader.TextFileReader;
import by.epam.task1.part1.store.TetrahedronStore;
import by.epam.task1.part1.validation.LineValidator;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;

import static by.epam.task1.reader.TextFileReaderTest.FILE_PATH;

public class GeometricalEntityParserTest {
    private TextFileReader reader;
    private GeometricalEntityParser parser;
    private TetrahedronStore expected;

    @Before
    public void init() {
        reader = new TextFileReader();
        parser = new GeometricalEntityParser();
        expected = new TetrahedronStore();
        expected.add(new Tetrahedron(new Point(1.0, 2.0, 3.5), new Point(4.5, 12.2, 0),
                new Point(14.4, 15.5, 0), new Point(17.7, 18.8, 0)));
    }

    @Test
    public void parse() throws IllegalFileInputException{
        ArrayList<String> lines = reader.readFile(FILE_PATH);
        LineValidator.validate(lines);
        TetrahedronStore store = parser.parse(lines);
        Assert.assertEquals(store, expected);
    }
}
