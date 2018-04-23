package by.epam.task1.creator;

import by.epam.task1.entity.GeometricalEntity;
import by.epam.task1.entity.Tetrahedron;

public class TetrahedronCreator extends GeometricalEntityCreator {
    @Override
    public GeometricalEntity create() {
        return new Tetrahedron();
    }
}
