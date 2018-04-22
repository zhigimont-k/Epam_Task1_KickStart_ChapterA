package by.epam.task1.reader;

import by.epam.task1.part1.entity.Point;
import by.epam.task1.part1.entity.Tetrahedron;
import by.epam.task1.part1.validation.ParameterValidator;
import org.junit.Test;
import org.testng.Assert;

public class ParameterValidatorTest {

    @Test
    public void validate(){
        Tetrahedron tetrahedron = new Tetrahedron(new Point(0, 1, 4), new Point(3, 3, 2),
                new Point(6, 1,2), new Point(9, 3, 2));
        boolean result = ParameterValidator.validate(tetrahedron);
        boolean expected = true;
        Assert.assertEquals(result, expected);
    }
}
