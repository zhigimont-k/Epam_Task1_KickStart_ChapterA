package by.epam.task1.reader;

import by.epam.task1.part1.exception.IllegalFileInputException;
import by.epam.task1.part1.reader.TextFileReader;
import by.epam.task1.part1.validation.LineValidator;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;

import static by.epam.task1.reader.TextFileReaderTest.FILE_PATH;


public class LineValidatorTest {
    private LineValidator validator;
    private TextFileReader reader;
    private ArrayList<String> expected;

    @Before
    public void init() {
        validator = new LineValidator();
        reader = new TextFileReader();
        expected = new ArrayList<>();
        expected.add("1.0 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6 17.7 18.8 19.9");
        expected.add("12.1 11.3 6.5 8.1 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        expected.add("7.3 8.9 4.2 3.1 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        expected.add("6.4 15.9 9.0 6.4 15.9 9.0 4.5 12.2 13.3 14.4 15.5 16.6");
    }

    @Test
    public void validate() throws IllegalFileInputException {
        ArrayList<String> lines = reader.readFile(FILE_PATH);
        validator.validate(lines);
        Assert.assertEquals(lines, expected);
    }
}
