package by.epam.task1.entity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Tetrahedron {
    private List<Point> points = new ArrayList<>();

    public Tetrahedron() {
    }

    public Tetrahedron(Point point1, Point point2, Point point3, Point point4) {
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);
    }

    public void setPoint(int index, Point point){
        points.set(index, point);
    }

    public Point get(int index) {
        return points.get(index);
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
        Tetrahedron other = (Tetrahedron) o;
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
        return "Tetrahedron(" + points + ')';
    }
}
