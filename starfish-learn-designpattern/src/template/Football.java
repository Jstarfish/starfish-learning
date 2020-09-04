package template;

/**
 * @description:
 * @author: starfish
 * @create: 2020-09-04 18:17
 */
public class Football extends Game{
    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}
