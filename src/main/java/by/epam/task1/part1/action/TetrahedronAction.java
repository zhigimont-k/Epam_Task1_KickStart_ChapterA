package by.epam.task1.part1.action;

import by.epam.task1.part1.entity.Point;
import by.epam.task1.part1.entity.Tetrahedron;
import by.epam.task1.part1.matrix.Matrix;
import by.epam.task1.part1.validation.ParameterValidator;

public class TetrahedronAction {
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
        double determinant = matrix.determinant();
        if (determinant < 0) {
            determinant = -determinant;
        }
        return determinant / 6;
    }

    public static double calculateVolumeRatio(Tetrahedron tetrahedron) {
        Point coordinatePlanePoint = new Point();
        Point vertex = new Point();
        if (isBasisParallelOx(tetrahedron)) {
            vertex = PointAction.findMaximumXPoint(tetrahedron);
            coordinatePlanePoint.setX(0);
            coordinatePlanePoint.setY(vertex.getY());
            coordinatePlanePoint.setZ(vertex.getZ());
        }
        if (isBasisParallelOy(tetrahedron)) {
            vertex = PointAction.findMaximumYPoint(tetrahedron);
            coordinatePlanePoint.setX(vertex.getX());
            coordinatePlanePoint.setY(0);
            coordinatePlanePoint.setZ(vertex.getZ());
        }
        if (isBasisParallelOz(tetrahedron)) {
            vertex = PointAction.findMaximumZPoint(tetrahedron);
            coordinatePlanePoint.setX(vertex.getX());
            coordinatePlanePoint.setY(vertex.getY());
            coordinatePlanePoint.setZ(0);
        }
        double similarityFactor = Math.pow(PointAction.calculateDistance(vertex, coordinatePlanePoint), 3);
        double wholeVolume = calculateVolume(tetrahedron);
        double truncatedTetrahedronVolume = wholeVolume / similarityFactor;
        return truncatedTetrahedronVolume / (wholeVolume - truncatedTetrahedronVolume);
    }

    public static boolean isBasisParallelOx(Tetrahedron tetrahedron) {
        Point point1 = tetrahedron.get(1);
        Point point2 = tetrahedron.get(2);
        Point point3 = tetrahedron.get(3);
        return point1.getX() == point2.getX() && point2.getX() == point3.getX();
    }

    public static boolean isBasisParallelOy(Tetrahedron tetrahedron) {
        Point point1 = tetrahedron.get(1);
        Point point2 = tetrahedron.get(2);
        Point point3 = tetrahedron.get(3);
        return point1.getY() == point2.getY() && point2.getY() == point3.getY();
    }

    public static boolean isBasisParallelOz(Tetrahedron tetrahedron) {
        Point point1 = tetrahedron.get(1);
        Point point2 = tetrahedron.get(2);
        Point point3 = tetrahedron.get(3);
        return point1.getZ() == point2.getZ() && point2.getZ() == point3.getZ();
    }

    public static boolean isTetrahedron(Object o) {
        Tetrahedron other = (Tetrahedron) o;
        return ParameterValidator.validate(other);
    }

    public static boolean isBasisOnCoordinatePlane(Tetrahedron tetrahedron) {
        Point point1 = tetrahedron.get(1);
        Point point2 = tetrahedron.get(2);
        Point point3 = tetrahedron.get(3);
        return (point1.getX() == 0 && point2.getX() == 0 && point3.getX() == 0) ||
                (point1.getY() == 0 && point2.getY() == 0 && point3.getY() == 0) ||
                (point1.getZ() == 0 && point2.getZ() == 0 && point3.getZ() == 0);
    }

}
