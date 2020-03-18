import javafx.print.Collation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import ru.abramov.lesson6_testing.CalcArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class CalcArrayTest {
    private static CalcArray calcArray;

    private boolean bool;
    private int[] arr;
    static int[] arr1 = {1, 2, 3, 4};
    static int[] ar1 = {};
    static int[] arr2 = {2, 4, 3, 2};
    static int[] ar2 = {3, 2};
    static int[] arr3 = {1, 4, 4, 1};
    static int[] ar3 = {1};
    static int[] arr4 = {1, 2, 3, 1};
    static int[] ar4 = {1, 2, 3, 1};
    private int[] arrActual;


    public CalcArrayTest(boolean bool, int[] arr, int[] arrActual) {
        this.bool = bool;
        this.arr = arr;
        this.arrActual = arrActual;
    }


    @Parameters
    public static Collection<Object[]> param() {
        return Arrays.asList(new Object[][]{
                {false, arr1, ar1},
                {false, arr2, ar2},
                {true, arr3, ar3},
                {false, arr4, ar4}
        });
    }

    @Test //true если есть 4 или 1
    public void iLoveFourAndOneTest() {
        Assert.assertEquals(calcArray.iLoveFourAndOne(arr), bool);
    }

    //возврат массива чисел после последней 4
    @Test
    public void pullerTest() {
        Assert.assertArrayEquals(calcArray.puller(arr), arrActual);
    }

    //если 4 нет то ожидаем Exception
    @Test(expected = RuntimeException.class)
    public void pullerTestException() {
        Assert.assertArrayEquals(calcArray.puller(arr), arrActual);
    }


    @Before
    public void init() {
        calcArray = new CalcArray();
        System.out.println("init calcArray");
    }

    @After
    public void clear() throws Exception {
        calcArray = null;
    }
}
