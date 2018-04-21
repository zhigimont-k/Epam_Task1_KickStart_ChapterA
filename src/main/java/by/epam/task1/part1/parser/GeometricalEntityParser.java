package by.epam.task1.part1.parser;

import by.epam.task1.part1.creator.GeometricalEntityCreator;
import by.epam.task1.part1.creator.PointCreator;
import by.epam.task1.part1.creator.PyramidCreator;
import by.epam.task1.part1.entity.GeometricalEntity;
import by.epam.task1.part1.entity.Point;
import by.epam.task1.part1.entity.Pyramid;
import by.epam.task1.part1.store.PyramidStore;
import by.epam.task1.part1.validation.ParameterValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class GeometricalEntityParser {
    public static final int PARAMETERS_NUMBER = 12;
    private static final int POINT_PARAMETERS_NUMBER = 3;
    private static final String SPLITTER = "\\s";
    private static Logger logger = LogManager.getLogger();

    public PyramidStore parse(ArrayList<String> strings) {
        PyramidStore store = new PyramidStore();
        ParameterValidator paramValidator = new ParameterValidator();
        GeometricalEntityCreator[] creators = {new PointCreator(), new PyramidCreator()};
        for (String line : strings) {
            String[] splitted = line.split(SPLITTER);
            double[] parameters = new double[PARAMETERS_NUMBER];
            ArrayList<Point> points = new ArrayList<>();
            for (int i = 0; i < PARAMETERS_NUMBER; i += POINT_PARAMETERS_NUMBER) {
                GeometricalEntity entity = creators[0].create();
                Point point = (Point) entity;
                point.setX(Double.parseDouble(splitted[i]));
                point.setY(Double.parseDouble(splitted[i + 1]));
                point.setZ(Double.parseDouble(splitted[i + 2]));
                points.add(point);
            }
            if (paramValidator.dataIsCorrect(points)) {
                GeometricalEntity entity = creators[1].create();
                Pyramid pyramid = (Pyramid) entity;
                pyramid.setPoints(points);
                store.add(pyramid);
                logger.log(Level.INFO, "Pyramid was added to store: " + pyramid);

            } else {
                logger.log(Level.INFO, "The following data is incorrect: " + line);
                continue;
            }
        }
        return store;
    }
}
