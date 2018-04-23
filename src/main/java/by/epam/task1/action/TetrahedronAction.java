package by.epam.task1.action;

import by.epam.task1.entity.Point;
import by.epam.task1.entity.Tetrahedron;
import by.epam.task1.matrix.Matrix;
import by.epam.task1.validation.ParameterValidator;

public class TetrahedronAction {
    private static final int MATRIX_ROWS = 4;

    public double calculateSurfaceArea(Tetrahedron tetrahedron) {
        double area = 0;
        area += calculateTriangleArea(tetrahedron.get(0), tetrahedron.get(1), tetrahedron.get(2));
        area += calculateTriangleArea(tetrahedron.get(0), tetrahedron.get(1), tetrahedron.get(3));
        area += calculateTriangleArea(tetrahedron.get(0), tetrahedron.get(2), tetrahedron.get(3));
        area += calculateTriangleArea(tetrahedron.get(1), tetrahedron.get(2), tetrahedron.get(3));
        return area;
    }

    public double calculateTriangleArea(Point point1, Point point2, Point point3) {
        PointAction action = new PointAction();
        double sideA = action.calculateDistance(point1, point2);
        double sideB = action.calculateDistance(point2, point3);
        double sideC = action.calculateDistance(point1, point3);
        double halfPerimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt((halfPerimeter * (halfPerimeter - sideA) *
                (halfPerimeter - sideB) * (halfPerimeter - sideC)));
    }

    public double calculateVolume(Tetrahedron tetrahedron) {
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
        return Math.abs(matrix.determinant() / 6);
    }

    public double calculateVolumeRatio(Tetrahedron tetrahedron) {
        PointAction action = new PointAction();
        Point coordinatePlanePoint = new Point();
        Point vertex = new Point();
        if (isBasisParallelOx(tetrahedron)) {
            vertex = action.findMaximumXPoint(tetrahedron);
            coordinatePlanePoint.setX(0);
            coordinatePlanePoint.setY(vertex.getY());
            coordinatePlanePoint.setZ(vertex.getZ());
        }
        if (isBasisParallelOy(tetrahedron)) {
            vertex = action.findMaximumYPoint(tetrahedron);
            coordinatePlanePoint.setX(vertex.getX());
            coordinatePlanePoint.setY(0);
            coordinatePlanePoint.setZ(vertex.getZ());
        }
        if (isBasisParallelOz(tetrahedron)) {
            vertex = action.findMaximumZPoint(tetrahedron);
            coordinatePlanePoint.setX(vertex.getX());
            coordinatePlanePoint.setY(vertex.getY());
            coordinatePlanePoint.setZ(0);
        }
        double similarityFactor = Math.pow(action.calculateDistance(vertex, coordinatePlanePoint), 3);
        double wholeVolume = calculateVolume(tetrahedron);
        double truncatedTetrahedronVolume = wholeVolume / similarityFactor;
        return truncatedTetrahedronVolume / (wholeVolume - truncatedTetrahedronVolume);
    }

    public boolean isBasisParallelOx(Tetrahedron tetrahedron) {
        Point point1 = tetrahedron.get(1);
        Point point2 = tetrahedron.get(2);
        Point point3 = tetrahedron.get(3);
        return point1.getX() == point2.getX() && point2.getX() == point3.getX();
    }

    public boolean isBasisParallelOy(Tetrahedron tetrahedron) {
        Point point1 = tetrahedron.get(1);
        Point point2 = tetrahedron.get(2);
        Point point3 = tetrahedron.get(3);
        return point1.getY() == point2.getY() && point2.getY() == point3.getY();
    }

    public boolean isBasisParallelOz(Tetrahedron tetrahedron) {
        Point point1 = tetrahedron.get(1);
        Point point2 = tetrahedron.get(2);
        Point point3 = tetrahedron.get(3);
        return point1.getZ() == point2.getZ() && point2.getZ() == point3.getZ();
    }

    public boolean isTetrahedron(Object o) {
        Tetrahedron other = (Tetrahedron) o;
        ParameterValidator validator = new ParameterValidator();
        return validator.validate(other);
    }

    public boolean isBasisOnCoordinatePlane(Tetrahedron tetrahedron) {
        Point point1 = tetrahedron.get(1);
        Point point2 = tetrahedron.get(2);
        Point point3 = tetrahedron.get(3);
        return (point1.getX() == 0 && point2.getX() == 0 && point3.getX() == 0) ||
                (point1.getY() == 0 && point2.getY() == 0 && point3.getY() == 0) ||
                (point1.getZ() == 0 && point2.getZ() == 0 && point3.getZ() == 0);
    }

}
