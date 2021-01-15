package ink.starfish.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        String s = "true";
        System.out.println(Boolean.parseBoolean(s));
        System.out.println(Boolean.getBoolean(s));
    }
}
