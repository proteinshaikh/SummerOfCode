import com.soc.MathUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestMathUtils {


    //testing static methods
    @Test
    public void testAdd() {
        int res = MathUtils.add(2, 3);
        Assert.assertEquals(5, res);
    }
}
