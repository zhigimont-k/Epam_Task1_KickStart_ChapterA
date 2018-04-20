package by.epam.task1.part1.entity;


import java.util.ArrayList;

public class Pyramid {
    private ArrayList<Point> points;
    Pyramid(){}
    Pyramid(Point point1, Point point2, Point point3, Point point4){
        points = new ArrayList<>();
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);
    }

}
