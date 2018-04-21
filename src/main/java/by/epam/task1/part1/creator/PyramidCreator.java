package by.epam.task1.part1.creator;

import by.epam.task1.part1.entity.GeometricalEntity;
import by.epam.task1.part1.entity.Pyramid;

public class PyramidCreator extends GeometricalEntityCreator {
    @Override
    public GeometricalEntity create() {
        return new Pyramid();
    }
}
