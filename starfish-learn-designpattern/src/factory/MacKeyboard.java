package factory;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-10 15:54
 **/
public class MacKeyboard implements Keyboard {

    @Override
    public void input() {
        System.out.println("Mac 专用键盘");
    }
}
