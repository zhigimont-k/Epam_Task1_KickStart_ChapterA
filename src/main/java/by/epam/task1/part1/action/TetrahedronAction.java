package by.epam.task1.part1.action;

import by.epam.task1.part1.entity.Point;
import by.epam.task1.part1.entity.Tetrahedron;
import by.epam.task1.part1.matrix.Matrix;
import by.epam.task1.part1.validation.ParameterValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class TetrahedronAction {
    private static Logger logger = LogManager.getLogger();
    private static final int MATRIX_SIZE = 16;
    private static final int MATRIX_ROWS = 4;
    private static final int POINTS_NUMBER = 4;

    public static double calculateSurfaceArea(Tetrahedron tetrahedron) {
        double area = 0;
        area += calculateTriangleArea(tetrahedron.get(0), tetrahedron.get(1), tetrahedron.get(2));
        area += calculateTriangleArea(tetrahedron.get(0), tetrahedron.get(1), tetrahedron.get(3));
        area += calculateTriangleArea(tetrahedron.get(0), tetrahedron.get(2), tetrahedron.get(3));
        area += calculateTriangleArea(tetrahedron.get(1), tetrahedron.get(2), tetrahedron.get(3));
        return area;
    }

    public static double calculateTriangleArea(Point point1, Point point2, Point point3) {
        double sideA = PointAction.calculateDistance(point1, point2);
        double sideB = PointAction.calculateDistance(point2, point3);
        double sideC = PointAction.calculateDistance(point1, point3);
        double halfPerimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt((halfPerimeter * (halfPerimeter - sideA) *
                (halfPerimeter - sideB) * (halfPerimeter - sideC)));
    }

    public static double calculateVolume(Tetrahedron tetrahedron) {
        double[][] coordinates = new double[MATRIX_ROWS][MATRIX_ROWS];
        for (int i = 0; i < MATRIX_ROWS; i++) {
            for (int j = 0; j < MATRIX_ROWS; j++) {
                if (j == 0) {
                    coordinates[i][j] = 1;
                }
                if (j == 1) {
                    coordinates[i][j] = tetrahedron.get(i).getX();
                }
                if (j == 2) {
                    coordinates[i][j] = tetrahedron.get(i).getY();
                }
                if (j == 3) {
                    coordinates[i][j] = tetrahedron.get(i).getZ();
                }
            }
        }
        Matrix matrix = new Matrix(coordinates);
        return matrix.determinant() / 6;
    }

    public static double calculateVolumeRatio(Tetrahedron tetrahedron) {
        return 0;
    }

    public static boolean isTetrahedron(Object o) {
        Tetrahedron other = (Tetrahedron) o;
        return ParameterValidator.validate(other);
    }

    public static boolean isBasisOnCoordinatePlane(Tetrahedron tetrahedron) {
        Point point1 = tetrahedron.get(0);
        Point point2 = tetrahedron.get(1);
        Point point3 = tetrahedron.get(2);
        Point point4 = tetrahedron.get(3);
        return false;
    }

}
