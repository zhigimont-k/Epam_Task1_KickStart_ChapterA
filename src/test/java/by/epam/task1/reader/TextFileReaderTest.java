package by.epam.task1.reader;

import by.epam.task1.part1.exception.IllegalFileInputException;
import by.epam.task1.part1.reader.TextFileReader;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;


public class TextFileReaderTest {
    protected final static String FILE_PATH = "data/input.txt";
    private final static String EMPTY_FILE_PATH = "data/empty.txt";
    private final static String WRONG_FILE_PATH = "data/inpu.txt";
    private ArrayList<String> expectedStringList;
    private TextFileReader reader = new TextFileReader();

    @Before
    public void initExpectedStringList(){
        expectedStringList = new ArrayList<>();
        expectedStringList.add("1.0 2.0 3.5 4.5 12.2 0 14.4 15.5 0 17.7 18.8 0");
        expectedStringList.add("9.0 11.0 8.0 7.0; 13.3 14.4 15.5 16.6 17.7 18.8 19.9");
        expectedStringList.add("12.1 11.3 6.5 8.1 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        expectedStringList.add("7.3 8.9 4.2 3.1 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        expectedStringList.add("10,2 6,4 8.1 12.0 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        expectedStringList.add("o4.5 8.0 7.5 6.12 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        expectedStringList.add("12;2 14.0 18,4 12,5 2.0 3.5 4.5 12.2 13.3 14.4 15.5 16.6");
        expectedStringList.add("6.4 15.9 9.0 6.4 15.9 9.0 4.5 12.2 13.3 14.4 15.5 16.6");
    }
    @Test
    public void readFilePositive() throws IllegalFileInputException {
        ArrayList<String> stringList = reader.readFile(FILE_PATH);
        Assert.assertEquals(stringList, expectedStringList);
    }

    @Test(expected = IllegalFileInputException.class)
    public void readEmptyFile() throws IllegalFileInputException {
        reader.readFile(EMPTY_FILE_PATH);
    }

    @Test(expected = IllegalFileInputException.class)
    public void readFileNotFound() throws IllegalFileInputException{
        reader.readFile(WRONG_FILE_PATH);
    }

}
