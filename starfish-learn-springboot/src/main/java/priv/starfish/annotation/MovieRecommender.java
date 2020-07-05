package priv.starfish.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: starfish
 * @create: 2020-06-30 17:03
 **/
@Component
public class MovieRecommender {

    @Value("${catalog.name}")
    private String catalog;

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public MovieRecommender(@Value("${catalog.name}") String catalog) {
        this.catalog = catalog;
    }


}
