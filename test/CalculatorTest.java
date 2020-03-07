import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import ru.abramov.lesson6_testing.Calculator;

public class CalculatorTest {

    private static Calculator calculator;

    @BeforeClass
    public static void init(){
        System.out.println("init calculator");
        calculator= new Calculator();
    }

    @Test
    public void justFail(){
        Assert.fail("бла бла бла");
    }

    @Test
    public void testAdd(){
        Assert.assertEquals(4, calculator.add(2,2));
    }

    @Test
    public void testMistakeAdd(){
        Assert.assertNotEquals(4,calculator.add(2,0));
    }

    @Test
    public void testDiv100y5(){
        Assert.assertEquals(calculator.div(10,5),2);
    }

    @Test(expected = ArithmeticException.class)
    public void testArithmeticExeption(){
        calculator.div(10,0);
    }

    @Ignore
    @Test
    public void testEmpty(){
        Assert.assertEquals(calculator.div(100,5),20);
        //Assert.fail();
    }

    @Test(timeout = 500)
    public void testTimeout(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testDiv(){
        Assert.assertEquals(calculator.div(100,10),10); //10
    }
}
