package Test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class DemoTest {


    @Test
    public void test(){
        int a = 1;
        Assert.assertEquals(1, a);
    }

}
