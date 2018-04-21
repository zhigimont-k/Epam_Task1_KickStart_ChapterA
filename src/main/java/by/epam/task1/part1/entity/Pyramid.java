package by.epam.task1.part1.entity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Pyramid implements GeometricalEntity{
    private ArrayList<Point> points;

    public Pyramid() {
    }

    public Pyramid(Point point1, Point point2, Point point3, Point point4) {
        points = new ArrayList<>();
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);
    }


    public Point get(int index) {
        return points.get(index);
    }

    public Point set(int index, Point element) {
        return points.set(index, element);
    }

    public void setPoints(Collection<? extends Point> c){
        points = new ArrayList<>();
        points.addAll(c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pyramid other = (Pyramid) o;
        int arraySize = points.size();
        for (int i = 0; i < arraySize; i++) {
            if (!points.get(i).equals(other.points.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        for (Point point : points) {
            hash += hash * 31 + point.hashCode();
        }
        return hash;
    }

    @Override
    public String toString() {
        return "Pyramid(" + points + ')';
    }
}
