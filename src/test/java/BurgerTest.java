import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void checkBunsTest() {
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200F);

        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals("white bun", bun.getName());
        Assert.assertEquals(200F, bun.getPrice(), 0);
    }

    @Test
    public void checkAddIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void checkRemoveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void checkMoveIngredientTest() {
        Burger burger = new Burger();
        Ingredient sauce = new Ingredient(SAUCE, "hot sauce", 100);
        Ingredient cutlet = new Ingredient(FILLING, "cutlet", 100);
        Ingredient sausage = new Ingredient(FILLING, "sausage", 300);
        burger.addIngredient(sauce);
        burger.addIngredient(cutlet);
        burger.addIngredient(sausage);
        burger.moveIngredient(0, 2);
        Assert.assertEquals(2, burger.ingredients.indexOf(sauce));
    }

    @Test
    public void checkGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(200F);

        Mockito.when(ingredient.getPrice()).thenReturn(100F);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float expResult = 500;
        float actResult = burger.getPrice();

        Assert.assertEquals(expResult, actResult, 0);
    }

    @Test
    public void checkGetReceiptTest() {
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);

        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200F);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actualResult = burger.getReceipt();

        String expResult = String.format("(==== white bun ====)%n" +
                "= sauce hot sauce =%n" +
                "(==== white bun ====)%n" +
                "%n" +
                "Price: 500,000000%n");
        Assert.assertEquals(expResult, actualResult);
    }
}
