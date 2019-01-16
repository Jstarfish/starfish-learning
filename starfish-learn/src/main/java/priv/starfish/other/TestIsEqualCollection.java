package priv.starfish.other;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEqualCollection;

/**
 * @author: jiahaixin
 * @date: 2018/11/15 11:39
 * @description:
 */

public class TestIsEqualCollection {





    @Test
    public void testIsEqual(){

        class Person{}
        class Girl extends Person{
        }

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        first.add(1);
        first.add(2);
        second.add(2);
        second.add(1);
        Girl goldGirl = new Girl();
        List<Person> boy1 = new ArrayList<>();
        //每个男孩心里都装着一个女孩
        boy1.add(new Girl());
        List<Person> boy2 = new ArrayList<>();
        //每个男孩心里都装着一个女孩
        boy2.add(new Girl());
        //比较两集合值
        System.out.println(CollectionUtils.isEqualCollection(first,second));   //true
        System.out.println(CollectionUtils.isEqualCollection(first,boy1));   //false
        System.out.println(CollectionUtils.isEqualCollection(boy1,boy2));   //false

        List<Person> boy3 = new ArrayList<>();
        //每个男孩心里都装着一个女孩
        boy3.add(goldGirl);
        List<Person> boy4 = new ArrayList<>();
        boy4.add(goldGirl);
        System.out.println(CollectionUtils.isEqualCollection(boy3,boy4));   //true
    }
}
