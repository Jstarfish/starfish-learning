package builder;

/**
 * @description: Builder interface defines all possible ways to configure a product.
 * @author: starfish
 * @date: 2021/6/9 11:17
 */
public interface CarBuilder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setGPS(GPS gps);
}
