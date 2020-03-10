package factory;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-10 15:55
 **/
public class MacFactory implements Hardware{

    @Override
    public Keyboard createKyeBoard() {
        return new MacKeyboard();
    }

    @Override
    public Mouse createMouse() {
        return new MacMouse();
    }
}
