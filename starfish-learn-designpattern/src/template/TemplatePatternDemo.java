package template;

/**
 * @description:
 * @author: starfish
 * @create: 2020-09-04 18:17
 */
public class TemplatePatternDemo {

    public static void main(String[] args) {

        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }

}
