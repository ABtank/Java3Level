import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.abramov.lesson6_testing.Calculator;

public class CalcTest {
    private Calculator calculator;

    @Before
    public void startTest() {
        calculator = new Calculator();
    }


    @Test
    public void testAdd() {
        //calculator = new Calculator();
        Assert.assertEquals(4, calculator.add(2, 2));
    }

    @Test
    public void testSub() {
        //calculator = new Calculator();
        Assert.assertEquals(3, calculator.sub(5, 2));
    }

    @Test
    public void testMul() {
        //calculator = new Calculator();
        Assert.assertEquals(9, calculator.mul(3, 3));
    }

    @Test
    public void testDiv() {
        //calculator = new Calculator();
        Assert.assertEquals(1, calculator.div(2, 2));
    }


    @Test
    @Ignore("Деление пока тестировать не нужно")
    public void testDiv2() {
        Assert.assertEquals(1, calculator.div(3, 3));
    }

    // timeout – задает количество миллисекунд,
    // по истечении которых тест будет помечен как failed
    @Test(timeout = 10000)
    public void doSomething(){
        // выполняем тяжелую задачу
    }

    //Параметр expected – можно указать класс Exception,
    // и если тест не выдаст необходимую ошибку,
    // то будет помечен как failed.
    @Test(expected = ArithmeticException.class)
    public void checkSomething() {
        // здесь должно появиться исключение
    }


}
