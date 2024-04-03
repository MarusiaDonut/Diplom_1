import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.IngredientType;

public class IngredientTypeTest {
    @Test
    public void checkValueSauceTest() {
        IngredientType sauce = IngredientType.valueOf("SAUCE");
        Assert.assertEquals("SAUCE", sauce.toString());
    }

    @Test
    public void checkValueFillingTest() {
        IngredientType filling = IngredientType.valueOf("FILLING");
        Assert.assertEquals("FILLING", filling.toString());
    }
}
