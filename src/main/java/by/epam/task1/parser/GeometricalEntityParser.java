package by.epam.task1.parser;

import by.epam.task1.entity.Point;
import by.epam.task1.entity.Tetrahedron;
import by.epam.task1.store.TetrahedronStore;
import by.epam.task1.validation.ParameterValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class GeometricalEntityParser {
    private static Logger logger = LogManager.getLogger();
    private static final int PARAMETERS_NUMBER = 12;
    private static final int POINT_PARAMETERS_NUMBER = 3;
    private static final String SPLITTER = "\\s";

    public TetrahedronStore parse(List<String> strings) {
        TetrahedronStore store = new TetrahedronStore();
        ParameterValidator validator = new ParameterValidator();
        for (String line : strings) {
            String[] splitted = line.split(SPLITTER);
            List<Point> points = new ArrayList<>();
            for (int i = 0; i < PARAMETERS_NUMBER; i += POINT_PARAMETERS_NUMBER) {
                Point point = new Point(
                        Double.parseDouble(splitted[i]),
                        Double.parseDouble(splitted[i + 1]),
                        Double.parseDouble(splitted[i + 2]));
                points.add(point);
            }
            Tetrahedron tetrahedron = new Tetrahedron();
            tetrahedron.setPoints(points);
            if (validator.validate(tetrahedron)) {
                logger.log(Level.INFO, "Tetrahedron was added to store: " + tetrahedron);
                store.add(tetrahedron);
            } else {
                logger.log(Level.INFO, "The following data is incorrect: " + line);
            }
        }
        return store;
    }
}
