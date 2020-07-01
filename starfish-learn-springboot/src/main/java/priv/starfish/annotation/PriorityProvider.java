package priv.starfish.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: starfish
 * @create: 2020-07-01 15:06
 **/
@Component
@PropertySource("classpath:values.properties")
public class PriorityProvider {

    private String priority;

    @Autowired
    public PriorityProvider(@Value("${priority:normal}") String priority) {
        this.priority = priority;
    }

    // standard getter


    public String getPriority() {
        return priority;
    }
}
