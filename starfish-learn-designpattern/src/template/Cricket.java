package template;

/**
 * @description:
 * @author: starfish
 * @create: 2020-09-04 18:16
 */
public class Cricket extends Game{

    @Override
    void initialize() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}
