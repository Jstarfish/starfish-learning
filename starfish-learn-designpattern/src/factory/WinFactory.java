package factory;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-10 15:56
 **/
public class WinFactory implements Hardware{

    @Override
    public Keyboard createKyeBoard() {
        return new WinKeyboard();
    }

    @Override
    public Mouse createMouse() {
        return new WinMouse();
    }
}
