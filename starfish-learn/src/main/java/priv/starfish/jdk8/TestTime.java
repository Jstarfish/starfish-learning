package priv.starfish.jdk8;

import java.time.Duration;
import java.time.Instant;


/**
 * https://jasonssun.github.io/2019/07/12/Java%E7%AC%94%E8%AE%B0%E4%B9%8Bjava8%E6%97%B6%E9%97%B4%E6%A0%BC%E5%BC%8F%E8%BD%AC%E6%8D%A2%E4%BB%A5%E5%8F%8A%E8%AE%A1%E7%AE%97%E6%97%B6%E9%97%B4%E5%B7%AE/
 */
public class TestTime {


    public static void main(String[] args) {

        Instant instant = Instant.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant2 = Instant.now();

        System.out.println(Duration.between(instant,instant2).getSeconds());




    }
}
