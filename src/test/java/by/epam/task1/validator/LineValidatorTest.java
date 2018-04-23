package by.epam.task1.validator;

import by.epam.task1.exception.IllegalFileInputException;
import by.epam.task1.reader.TextFileReader;
import by.epam.task1.validation.LineValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LineValidatorTest {
    private final static String FILE_PATH = "data/input.txt";

    @DataProvider(name = "dataProvider")
    public Object[][] provideData()  throws IllegalFileInputException {
        List<String> expected = new ArrayList<>();
        expected.add("1.0 2.0 3.5 4.5 12.2 0 14.4 15.5 0 17.7 18.8 0");
        expected.add("12.1 11.3 6.5 8.1 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        expected.add("7.3 8.9 4.2 3.1 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        expected.add("6.4 15.9 9.0 6.4 15.9 9.0 4.5 12.2 13.3 14.4 15.5 16.6");

        List<String> lines = new TextFileReader().readFile(FILE_PATH);
        new LineValidator().validate(lines);
        return new Object[][]{{lines, expected}};
    }

    @Test(dataProvider = "dataProvider")
    public void validate(List<String> lines, List<String> expected){
        Assert.assertEquals(lines, expected);
    }
}
