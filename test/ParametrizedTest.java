import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import ru.abramov.lesson6_testing.Calculator;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ParametrizedTest {
    private static Calculator calculator;

    private int res;
    private boolean resBool;
    private int x1;
    private int x2;
    private String m;
    private int z;
    private int q;


    public ParametrizedTest(int x1, int x2, boolean resBool, int z, int q, String m, int res) {
        this.x1 = x1;
        this.x2 = x2;
        this.resBool = resBool;
        this.z = z;
        this.q = q;
        this.m = m;
        this.res = res;
    }


    //класс который возвращает коллекцию которая
    // автоматически подставляется в последствии в наш конструктор
    @Parameters
    public static Collection abracadabra() {
        return Arrays.asList(new Object[][]{
                {5, 5, true, 5, 5, "10", 10},
                {5, 50, false, 5, 5, "10", 55},
                {5, -5, false, 5, 5, "10", -0}
        });
    }

    @Test
    public void boolTest(){
        Assert.assertEquals(calculator.bool(x1,x2),resBool);
    }

    @Test
    public void boolTestHard(){
        Assert.assertEquals(calculator.hardDiv(x1,x1,z,q,m),0);
    }

    @Test
    public void paramAddingTest(){
        Assert.assertEquals(res,calculator.add(x1,x2));
    }

    @Before
    public void init(){
        System.out.println("init calculator");
        calculator= new Calculator();
    }

    //чтоб не забивать память
    @After
    public void tearDown() throws Exception{
        calculator = null;
    }



}
