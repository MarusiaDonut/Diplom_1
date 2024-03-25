import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    public IngredientParametrizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] testBurgerData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", 200}
        };
    }

    @Test
    public void Test() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(ingredient.getType(), type);
        Assert.assertEquals(ingredient.getName(), name);
        Assert.assertEquals(ingredient.getPrice(), price, 0);
    }

}
