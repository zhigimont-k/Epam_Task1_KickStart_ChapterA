package by.epam.task1.validation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class LineValidator {
    private static final String PATTERN = "(^(((-))?((\\d+((\\.)\\d+)?)\\s){11}(((-))?((\\d+((\\.|,)\\d+)?))))$)";
    private static Logger logger = LogManager.getLogger();

    public void validate(List<String> lines) {
        List<String> wrongLines = new ArrayList<>();
        for (String line : lines) {
            if (!line.matches(PATTERN)) {
                logger.log(Level.INFO, "The following line was omitted: " + line);
                wrongLines.add(line);
            }
        }
        lines.removeAll(wrongLines);
    }
}
