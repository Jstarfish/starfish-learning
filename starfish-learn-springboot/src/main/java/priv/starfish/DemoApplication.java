package priv.starfish;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import priv.starfish.mybatis.mapper.FeedSchemaMapper;

@SpringBootApplication
@MapperScan(basePackages = "priv.starfish.mybatis.mapper")
public class DemoApplication {



    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);



    }

}
