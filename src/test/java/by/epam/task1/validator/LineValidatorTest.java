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
    private LineValidator validator;

    @BeforeClass
    public void init() {
        validator = new LineValidator();
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData() {
        List<String> list = new ArrayList<>();
        list.add("1.0 2.0 3.5 4.5 12.2 0 14.4 15.5 0 17.7 18.8 0");
        list.add("9.0 11.0 8.0 7.0; 13.3 14.4 15.5 16.6 17.7 18.8 19.9");
        list.add("12.1 11.3 6.5 8.1 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        list.add("7.3 8.9 4.2 3.1 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        list.add("10,2 6,4 8.1 12.0 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        list.add("o4.5 8.0 7.5 6.12 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        list.add("12;2 14.0 18,4 12,5 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        list.add("6.4 15.9 9.0 6.4 15.9 9.0 4.5 12.2 13.3 14.4 15.5 16.6");

        List<String> expected = new ArrayList<>();
        expected.add("1.0 2.0 3.5 4.5 12.2 0 14.4 15.5 0 17.7 18.8 0");
        expected.add("12.1 11.3 6.5 8.1 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        expected.add("7.3 8.9 4.2 3.1 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        expected.add("6.4 15.9 9.0 6.4 15.9 9.0 4.5 12.2 13.3 14.4 15.5 16.6");

        return new Object[][]{{validator.validate(list), expected}};
    }

    @Test(dataProvider = "dataProvider")
    public void validate(List<String> lines, List<String> expected) {
        Assert.assertEquals(lines, expected);
    }
}
