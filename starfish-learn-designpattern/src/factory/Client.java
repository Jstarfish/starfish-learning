package factory;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-10 15:58
 **/
public class Client {

    public static void main(String[] args) {
        Hardware macFactory = new MacFactory();
        Keyboard keyboard = macFactory.createKyeBoard();
        keyboard.input();

        Hardware winFactory = new WinFactory();
        Mouse mouse = winFactory.createMouse();
        mouse.click();
    }
}
