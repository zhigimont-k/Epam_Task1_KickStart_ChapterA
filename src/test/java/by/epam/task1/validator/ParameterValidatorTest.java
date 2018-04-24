package by.epam.task1.validator;

import by.epam.task1.entity.Point;
import by.epam.task1.entity.Tetrahedron;
import by.epam.task1.validation.ParameterValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ParameterValidatorTest {

    private ParameterValidator validator;

    @BeforeClass
    public void init() {
        validator = new ParameterValidator();
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData() {
        Tetrahedron tetrahedron = new Tetrahedron(new Point(0, 1, 4), new Point(3, 3, 2),
                new Point(6, 1, 2), new Point(9, 3, 2));
        boolean result1 = validator.validate(tetrahedron);
        tetrahedron.setPoint(0, new Point(0, 1, 2));
        boolean result2 = validator.validate(tetrahedron);
        return new Object[][]{{result1, true}, {result2, false}};
    }

    @Test(dataProvider = "dataProvider")
    public void validate(boolean result, boolean expected) {
        Assert.assertEquals(result, expected);
    }
}
