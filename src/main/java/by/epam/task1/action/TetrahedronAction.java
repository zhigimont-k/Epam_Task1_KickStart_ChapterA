package by.epam.task1.action;

import by.epam.task1.entity.Point;
import by.epam.task1.entity.Tetrahedron;
import by.epam.task1.matrix.MatrixDeterminantCalculator;
import by.epam.task1.validation.ParameterValidator;

import java.util.ArrayList;

public class TetrahedronAction {
    private static final int POINTS_NUMBER = 4;

    public double calculateSurfaceArea(Tetrahedron tetrahedron) {
        double area = calculateTriangleArea(tetrahedron.get(0), tetrahedron.get(1), tetrahedron.get(2));
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
        double[][] coordinates = new double[POINTS_NUMBER][POINTS_NUMBER];
        for (int i = 0; i < POINTS_NUMBER; i++) {
            for (int j = 0; j < POINTS_NUMBER; j++) {
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
        return Math.abs(new MatrixDeterminantCalculator(coordinates).determinant() / 6);
    }

    public double calculateVolumeRatio(Tetrahedron tetrahedron) {
        PointAction action = new PointAction();
        Point coordinatePlanePoint = new Point();
        Point vertex = new Point();
        if (checkBasisParallelOx(tetrahedron)) {
            vertex = findMaximumXPoint(tetrahedron);
            coordinatePlanePoint.setX(0);
            coordinatePlanePoint.setY(vertex.getY());
            coordinatePlanePoint.setZ(vertex.getZ());
        }
        if (checkBasisParallelOy(tetrahedron)) {
            vertex = findMaximumYPoint(tetrahedron);
            coordinatePlanePoint.setX(vertex.getX());
            coordinatePlanePoint.setY(0);
            coordinatePlanePoint.setZ(vertex.getZ());
        }
        if (checkBasisParallelOz(tetrahedron)) {
            vertex = findMaximumZPoint(tetrahedron);
            coordinatePlanePoint.setX(vertex.getX());
            coordinatePlanePoint.setY(vertex.getY());
            coordinatePlanePoint.setZ(0);
        }
        double similarityFactor = Math.pow(action.calculateDistance(vertex, coordinatePlanePoint), 3);
        double wholeVolume = calculateVolume(tetrahedron);
        double truncatedTetrahedronVolume = wholeVolume / similarityFactor;
        return truncatedTetrahedronVolume / (wholeVolume - truncatedTetrahedronVolume);
    }

    public boolean checkBasisParallelOx(Tetrahedron tetrahedron) {
        Point point1 = tetrahedron.get(1);
        Point point2 = tetrahedron.get(2);
        Point point3 = tetrahedron.get(3);
        return point1.getX() == point2.getX() && point2.getX() == point3.getX();
    }

    public boolean checkBasisParallelOy(Tetrahedron tetrahedron) {
        Point point1 = tetrahedron.get(1);
        Point point2 = tetrahedron.get(2);
        Point point3 = tetrahedron.get(3);
        return point1.getY() == point2.getY() && point2.getY() == point3.getY();
    }

    public boolean checkBasisParallelOz(Tetrahedron tetrahedron) {
        Point point1 = tetrahedron.get(1);
        Point point2 = tetrahedron.get(2);
        Point point3 = tetrahedron.get(3);
        return point1.getZ() == point2.getZ() && point2.getZ() == point3.getZ();
    }

    public boolean checkTetrahedron(Object o) {
        Tetrahedron other = (Tetrahedron) o;
        ParameterValidator validator = new ParameterValidator();
        return validator.validate(other);
    }

    public boolean checkBasisOnCoordinatePlane(Tetrahedron tetrahedron) {
        Point point1 = tetrahedron.get(1);
        Point point2 = tetrahedron.get(2);
        Point point3 = tetrahedron.get(3);
        return point1.getX() == 0 && point2.getX() == 0 && point3.getX() == 0 ||
                point1.getY() == 0 && point2.getY() == 0 && point3.getY() == 0 ||
                point1.getZ() == 0 && point2.getZ() == 0 && point3.getZ() == 0;
    }


    private Point findMaximumXPoint(Tetrahedron tetrahedron) {
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < POINTS_NUMBER; i++) {
            points.add(tetrahedron.get(i));
        }
        Point max = points.get(0);
        for (Point point : points) {
            max = (point.getX() > max.getX()) ? point : max;
        }
        return max;
    }

    private Point findMaximumYPoint(Tetrahedron tetrahedron) {
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < POINTS_NUMBER; i++) {
            points.add(tetrahedron.get(i));
        }
        Point max = points.get(0);
        for (Point point : points) {
            max = (point.getY() > max.getY()) ? point : max;
        }
        return max;
    }

    private Point findMaximumZPoint(Tetrahedron tetrahedron) {
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < POINTS_NUMBER; i++) {
            points.add(tetrahedron.get(i));
        }
        Point max = points.get(0);
        for (Point point : points) {
            max = (point.getZ() > max.getZ()) ? point : max;
        }
        return max;
    }

}
