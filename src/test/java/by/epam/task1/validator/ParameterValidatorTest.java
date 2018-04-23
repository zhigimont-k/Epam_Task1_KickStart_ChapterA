package by.epam.task1.validator;

import by.epam.task1.entity.Point;
import by.epam.task1.entity.Tetrahedron;
import by.epam.task1.validation.ParameterValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ParameterValidatorTest {

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(){
        Tetrahedron tetrahedron = new Tetrahedron(new Point(0, 1, 4), new Point(3, 3, 2),
                new Point(6, 1,2), new Point(9, 3, 2));
        boolean result = new ParameterValidator().validate(tetrahedron);
        boolean expected = true;
        return new Object[][]{{result, expected}};
    }
    @Test(dataProvider = "dataProvider")
    public void validate(boolean result, boolean expected){
        Assert.assertEquals(result, expected);
    }
}
