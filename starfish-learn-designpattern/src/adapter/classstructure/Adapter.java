package adapter.classstructure;

/**
 * @description:
 * @author: starfish
 * @data: 2020-06-07 11:51
 **/
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        //...一些操作...
        super.adapteeRequest();
        //...一些操作...
    }
}
