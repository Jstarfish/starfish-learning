package builder;

/**
 * @description: 主管控制生成器
 * @author: starfish
 * @date: 2021/6/9 11:31
 */
public class Director {

    public void constructSportsCar(CarBuilder builder){
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(2.0,0));
        builder.setGPS(new GPS());
    }

    public void constructCityCar(CarBuilder builder){
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(4);
        builder.setEngine(new Engine(1.5,0));
        builder.setGPS(new GPS());
    }

    public void constructSUVCar(CarBuilder builder){
        builder.setCarType(CarType.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.5,0));
        builder.setGPS(new GPS());
    }

}
