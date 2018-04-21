package by.epam.task1.part1.validation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class LineValidator {
    private final static String PATTERN = "(^(((-))?((\\d+((\\.)\\d+)?)\\s){11}(((-))?((\\d+((\\.|,)\\d+)?))))$)";
    private static Logger logger = LogManager.getLogger();

    public void validate(ArrayList<String> lines) {
        ArrayList<String> wrongLines = new ArrayList<>();
        for (String line : lines) {
            if (!line.matches(PATTERN)) {
                logger.log(Level.INFO, "The following line was omitted: " + line);
                wrongLines.add(line);
            }
        }
        lines.removeAll(wrongLines);
    }
}
