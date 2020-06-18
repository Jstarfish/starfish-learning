package priv.starfish.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description:
 * @author: starfish
 * @create: 2020-06-08 14:04
 **/

@RestController
//@RequestMapping("/call")
public class HystrixDemoController {


    @RequestMapping(value = "/call")
    @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String hello() throws InterruptedException {
        Thread.sleep(3000);
        //if redis 中数量超过500 ，throw exception
        return "Welcome Hystrix";
    }
    private String fallback_hello() {
        return "Request fails. It takes long time to response";
    }
}
