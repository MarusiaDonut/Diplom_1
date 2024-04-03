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
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] testBurgerData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300}
        };
    }

    @Test
    public void ingredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(ingredient.getType(), type);
        Assert.assertEquals(ingredient.getName(), name);
        Assert.assertEquals(ingredient.getPrice(), price, 0);
    }

    @Test
    public  void addIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertFalse(burger.ingredients.isEmpty());
    }
}
