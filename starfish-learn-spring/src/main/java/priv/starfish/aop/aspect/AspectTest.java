package priv.starfish.aop.aspect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @description:
 * @author: starfish
 * @date: 2021/7/14 20:39
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AspectTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void test(){
        int res = calculator.add(1,2);
        System.out.println("res:"+res);

        //calculator.div(1,0);
    }

}
