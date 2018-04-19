package by.epam.task1.reader;

import by.epam.task1.part1.exception.IllegalFileInputException;
import by.epam.task1.part1.reader.TextFileReader;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class TextFileReaderTest {
    private final static String FILE_PATH = "files/input.txt";
    private final static String EMPTY_FILE_PATH = "";
    private final static String WRONG_FILE_PATH = "files/inpu.txt";
    private TextFileReader reader = new TextFileReader();

    @Test
    public void readFilePositive() {
        try {
            reader.readFile(FILE_PATH);
        } catch (IllegalFileInputException e){
            Assert.fail();
        }
    }

    @Test
    public void readEmptyFile() {
    }

    @Test
    public void readFileNotFound() {
    }

}
