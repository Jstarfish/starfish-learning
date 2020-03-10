package factory;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-10 15:55
 **/
public class WinKeyboard implements Keyboard {

    @Override
    public void input() {
        System.out.println("Win 专用键盘");
    }
}
