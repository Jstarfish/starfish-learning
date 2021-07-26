package priv.starfish.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: starfish
 * @date: 2021/7/22 20:42
 */
@Order(3)
@Aspect
@Component
public class CalculatorMaxMinAspect {

    @DeclareParents(value="* *.PureCalculator",defaultImpl=MaxCalculatorImpl.class)
    private IMaxCalculator maxCalculator;

    @DeclareParents(value="* *.PureCalculator",defaultImpl=MinCalculatorImpl.class)
    private IMinCalculator minCalculator;

}
