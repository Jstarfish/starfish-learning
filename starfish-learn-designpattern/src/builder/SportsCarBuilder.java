package builder;

/**
 * @description: 跑车
 * @author: starfish
 * @date: 2021/6/9 11:18
 */
public class SportsCarBuilder implements CarBuilder {

    private CarType carType;
    private int seats;
    private Engine engine;
    private GPS gps;

    @Override
    public void setCarType(CarType type) {
        this.carType = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setGPS(GPS gps) {
        this.gps = gps;
    }

    public Car getResult() {
        return new Car(carType, seats, engine, gps);
    }
}
