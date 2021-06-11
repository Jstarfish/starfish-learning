package builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description:
 * @author: starfish
 * @date: 2021/6/9 11:41
 */
@Setter
@Getter
@ToString
public class Car {

    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final GPS gps;
    private double fuel;

    public Car(CarType carType,int seats,Engine engine,GPS gps){
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.gps = gps;
    }
}
