package by.epam.task1.part1.action;

import by.epam.task1.part1.entity.Point;
import by.epam.task1.part1.entity.Tetrahedron;

import java.util.ArrayList;

public class PointAction {
    private static final int POINTS_NUMBER = 4;

    public static double calculateDistance(Point first, Point second) {
        return Math.sqrt(Math.pow(second.getX() - first.getX(), 2) +
                Math.pow(second.getY() - first.getY(), 2) +
                Math.pow(second.getZ() - first.getZ(), 2));
    }

    public static Point findMaximumXPoint(Tetrahedron tetrahedron){
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < POINTS_NUMBER; i++){
            points.add(tetrahedron.get(i));
        }
        Point max = points.get(0);
        for (Point point : points){
            if (point.getX() > max.getX()){
                max = point;
            }
        }
        return max;
    }

    public static Point findMaximumYPoint(Tetrahedron tetrahedron){
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < POINTS_NUMBER; i++){
            points.add(tetrahedron.get(i));
        }
        Point max = points.get(0);
        for (Point point : points){
            if (point.getY() > max.getY()){
                max = point;
            }
        }
        return max;
    }

    public static Point findMaximumZPoint(Tetrahedron tetrahedron){
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < POINTS_NUMBER; i++){
            points.add(tetrahedron.get(i));
        }
        Point max = points.get(0);
        for (Point point : points){
            if (point.getZ() > max.getZ()){
                max = point;
            }
        }
        return max;
    }
}
