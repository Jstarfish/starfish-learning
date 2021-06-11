package builder;

/**
 * @description:
 * @author: starfish
 * @date: 2021/6/9 11:38
 */
public class Client {

    public static void main(String[] args) {
        Director director = new Director();
        SportsCarBuilder builder = new SportsCarBuilder();
        director.constructSportsCar(builder);

        Car car = builder.getResult();
        System.out.println(car.toString());
    }
}
