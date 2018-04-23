package by.epam.task1.reader;

import by.epam.task1.exception.IllegalFileInputException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class TextFileReaderTest {
    private final static String FILE_PATH = "data/input.txt";
    private final static String EMPTY_FILE_PATH = "data/empty.txt";
    private final static String WRONG_FILE_PATH = "data/inpu.txt";
    private TextFileReader reader;


    @BeforeClass
    public void init(){
        reader = new TextFileReader();
    }
    @DataProvider(name = "dataProvider")
    public Object[][] provideData() throws IllegalFileInputException {
        List<String> expected = new ArrayList<>();
        expected.add("1.0 2.0 3.5 4.5 12.2 0 14.4 15.5 0 17.7 18.8 0");
        expected.add("9.0 11.0 8.0 7.0; 13.3 14.4 15.5 16.6 17.7 18.8 19.9");
        expected.add("12.1 11.3 6.5 8.1 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        expected.add("7.3 8.9 4.2 3.1 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        expected.add("10,2 6,4 8.1 12.0 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        expected.add("o4.5 8.0 7.5 6.12 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        expected.add("12;2 14.0 18,4 12,5 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        expected.add("6.4 15.9 9.0 6.4 15.9 9.0 4.5 12.2 13.3 14.4 15.5 16.6");

        List<String> stringList = reader.readFile(FILE_PATH);
        return new Object[][]{{stringList, expected}};
    }
    @Test(dataProvider = "dataProvider")
    public void readFilePositive(List<String> stringList, List<String> expected){
        Assert.assertEquals(stringList, expected);
    }

    @Test(expectedExceptions = IllegalFileInputException.class)
    public void readEmptyFile() throws IllegalFileInputException {
        reader.readFile(EMPTY_FILE_PATH);
    }

    @Test(expectedExceptions = IllegalFileInputException.class)
    public void readFileNotFound() throws IllegalFileInputException{
        reader.readFile(WRONG_FILE_PATH);
    }

}
