package by.epam.task1.part1.entity;

public class Point implements GeometricalEntity{
    private double x;
    private double y;
    private double z;

    public Point() {
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point other = (Point) o;
        return x == other.x && y == other.y && z == other.z;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash += hash * 31 + x + y + z;
        return hash;
    }
    
    @Override
    public String toString() {
        return "Point(" +
                x + ", " +
                y + ", " +
                z + ')';
    }
}
