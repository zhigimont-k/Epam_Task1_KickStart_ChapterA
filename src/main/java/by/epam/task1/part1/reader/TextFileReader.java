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
import java.util.stream.Stream;

public class TextFileReader {
    private static Logger logger = LogManager.getLogger();

    public ArrayList<String> readFile(String fileName) throws IllegalFileInputException {
        File file = new File(fileName);
        if (!file.exists()) {
            logger.log(Level.ERROR, "Attempt to read non-existent file.");
            throw new IllegalFileInputException("File doesn't exist.");
        }
        if (file.length() == 0) {
            logger.log(Level.ERROR, "Attempt to read empty file.");
            throw new IllegalFileInputException("File is empty.");
        }
        ArrayList<String> linesList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(linesList::add);
        } catch (IOException e) {
            logger.catching(Level.FATAL, e);
            throw new RuntimeException(e);
        }
        logger.log(Level.INFO, "Lines read: " + linesList);
        return linesList;
    }
}
