package by.epam.task1.part1.validation;

import by.epam.task1.part1.entity.Point;

import java.util.ArrayList;


public class ParameterValidator {

    public boolean dataIsCorrect(ArrayList<Point> points) {
        ArrayList<Point> foundPoints = new ArrayList<>();
        for (Point point : points){
            if (foundPoints.contains(point)){
                return false;
            }
            foundPoints.add(point);
        }
        return true;
    }
}
