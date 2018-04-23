package by.epam.task1.creator;

import by.epam.task1.entity.GeometricalEntity;
import by.epam.task1.entity.Point;

public class PointCreator extends GeometricalEntityCreator {
    @Override
    public GeometricalEntity create() {
        return new Point();
    }
}
