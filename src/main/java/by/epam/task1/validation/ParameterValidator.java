package by.epam.task1.validation;

import by.epam.task1.action.TetrahedronAction;
import by.epam.task1.entity.Point;
import by.epam.task1.entity.Tetrahedron;
import by.epam.task1.matrix.Matrix;

import java.util.ArrayList;
import java.util.List;


public class ParameterValidator {
    private static final int POINT_MATRIX_ROWS = 2;
    private static final int PLANE_MATRIX_ROWS = 4;
    private static final int POINTS_NUMBER = 4;

    public boolean validate(Tetrahedron tetrahedron) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < POINTS_NUMBER; i++) {
            points.add(tetrahedron.get(i));
        }
        return pointsAreUnique(points) && pointsFormPlane(points) &&
                arePointsInDifferentPlanes(points) && isBasisParallelCoordinatePlane(tetrahedron);
    }

    private boolean pointsAreUnique(List<Point> points) {
        List<Point> foundPoints = new ArrayList<>();
        for (Point point : points) {
            if (foundPoints.contains(point)) {
                return false;
            }
            foundPoints.add(point);
        }
        return true;
    }

    private boolean pointsFormPlane(List<Point> points) {
        double[][] data = new double[POINT_MATRIX_ROWS][POINT_MATRIX_ROWS];
        data[0][0] = points.get(2).getX() - points.get(1).getX();
        data[0][1] = points.get(2).getY() - points.get(1).getY();
        data[1][0] = points.get(3).getX() - points.get(1).getY();
        data[1][1] = points.get(3).getY() - points.get(1).getY();
        Matrix matrix = new Matrix(data);
        return matrix.determinant() != 0;
    }

    private boolean arePointsInDifferentPlanes(List<Point> points) {
        double[][] coordinates = new double[PLANE_MATRIX_ROWS][PLANE_MATRIX_ROWS];
        for (int i = 0; i < PLANE_MATRIX_ROWS; i++) {
            for (int j = 0; j < PLANE_MATRIX_ROWS; j++) {
                if (j == 0) {
                    coordinates[i][j] = 1;
                }
                if (j == 1) {
                    coordinates[i][j] = points.get(i).getX();
                }
                if (j == 2) {
                    coordinates[i][j] = points.get(i).getY();
                }
                if (j == 3) {
                    coordinates[i][j] = points.get(i).getZ();
                }
            }
        }
        Matrix matrix = new Matrix(coordinates);
        return matrix.determinant() != 0;
    }

    private boolean isBasisParallelCoordinatePlane(Tetrahedron tetrahedron) {
        TetrahedronAction action = new TetrahedronAction();
        return action.isBasisParallelOx(tetrahedron) ||
                action.isBasisParallelOy(tetrahedron) ||
                action.isBasisParallelOz(tetrahedron);
    }
}
