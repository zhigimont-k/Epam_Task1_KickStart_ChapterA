package by.epam.task1.part1.reader;

import by.epam.task1.part1.exception.IllegalFileInputException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TextFileReader {
    private static Logger logger = LogManager.getLogger();

    public List<String> readFile(String fileName) throws IllegalFileInputException{
        if (fileIsEmpty(fileName)){
            throw new IllegalFileInputException("File is empty.");
        }
        List<String> linesList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(linesList::add);
        } catch (IOException e) {
            logger.catching(Level.FATAL, e);
            throw new RuntimeException(e);
        }
        return linesList;
    }

    private boolean fileIsEmpty(String fileName){
        File file = new File(fileName);
        return file.length() == 0;
    }
}
