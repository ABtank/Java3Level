import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.abramov.lesson6_testing.CalcArray;

public class ArrayTest {

    public static CalcArray calcArray;


    static int[] arr1 = {1, 4, 1, 4};
    static int[] arr2 = {2, 4, 3, 2};

    static int []ar={3,2};


    @Test //
    public void iLoveFourAndOneTest() {
        Assert.assertEquals(calcArray.iLoveFourAndOne(arr1), true);
    }

    @Test //возврат массива чисел после последней 4
    public void pullerTest() {
        Assert.assertArrayEquals(calcArray.puller(arr2), ar);
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
