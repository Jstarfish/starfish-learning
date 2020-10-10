package priv.starfish.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: starfish
 * @create: 2020-09-01 14:55
 */
@Component
public class BeanB {

    //@Autowired
    private BeanA beanA;

    @Autowired
    public BeanB(BeanA beanA){
        this.beanA = beanA;
    }

}
