package adapter.classstructure;

/**
 * @description:
 * @author: starfish
 * @data: 2020-06-07 11:51
 **/
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("concreteTarget目标方法");
    }
}
