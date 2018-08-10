package priv.starfish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 
 * @param:  * @param null
 * @return: 
 * @auther: jiahaixin
 * @date: 2018/8/9 11:11
 */
@SpringBootApplication
@RestController
public class CloudAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudAppApplication.class, args);
    }


    @GetMapping("/hello")
    public String hello() {
        return "Hello, fang";
    }

}
