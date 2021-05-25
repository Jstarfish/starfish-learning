package priv.starfish.demo;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import priv.starfish.DemoApplication;
import priv.starfish.mybatis.dto.FeedSchemaContentDto;
import priv.starfish.mybatis.dto.FeedSchemaDto;
import priv.starfish.mybatis.mapper.FeedSchemaMapper;
import priv.starfish.mybatis.model.IndustryFieldDO;

import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: starfish
 * @date: 2021/2/8 19:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Configuration
public class ApplicationTests {


}
