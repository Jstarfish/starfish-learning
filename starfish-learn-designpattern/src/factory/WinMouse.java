package factory;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-10 15:54
 **/
public class WinMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("win 专用鼠标");
    }
}
