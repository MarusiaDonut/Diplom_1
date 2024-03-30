import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

public class BunTest {

    @Test
    public void checkNameTest() {
        Bun bun = new Bun("white bun", 200);
        String expResult = "white bun";
        String actResult = bun.getName();
        Assert.assertEquals(expResult, actResult);
    }

    @Test
    public void checkPriceTest() {
        Bun bun = new Bun("white bun", 200);
        float expResult = 200;
        float actResult = bun.getPrice();
        Assert.assertEquals(expResult, actResult, 0);
    }
}
