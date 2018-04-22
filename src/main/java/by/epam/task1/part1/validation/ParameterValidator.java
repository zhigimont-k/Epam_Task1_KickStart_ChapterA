package by.epam.task1.part1.validation;

import by.epam.task1.part1.entity.Point;
import by.epam.task1.part1.entity.Tetrahedron;
import by.epam.task1.part1.matrix.Matrix;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class ParameterValidator {
    private static final int POINT_MATRIX_ROWS = 2;
    private static final int PLANE_MATRIX_ROWS = 4;
    private static final int POINTS_NUMBER = 4;

    public static boolean validate(Tetrahedron tetrahedron){
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < POINTS_NUMBER; i++){
            points.add(tetrahedron.get(i));
        }
        return pointsAreUnique(points) && pointsFormPlane(points) && arePointsInDifferentPlanes(points);
    }

    private static boolean pointsAreUnique(ArrayList<Point> points) {
        ArrayList<Point> foundPoints = new ArrayList<>();
        for (Point point : points){
            if (foundPoints.contains(point)){
                return false;
            }
            foundPoints.add(point);
        }
        return true;
    }

    private static boolean pointsFormPlane(ArrayList<Point> points){
        double[][] data = new double[POINT_MATRIX_ROWS][POINT_MATRIX_ROWS];
        data[0][0] = points.get(2).getX() - points.get(1).getX();
        data[0][1] = points.get(2).getY() - points.get(1).getY();
        data[1][0] = points.get(3).getX() - points.get(1).getY();
        data[1][1] = points.get(3).getY() - points.get(1).getY();
        Matrix matrix = new Matrix(data);
        return matrix.determinant() != 0;
    }

    private static boolean arePointsInDifferentPlanes(ArrayList<Point> points){
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
}
