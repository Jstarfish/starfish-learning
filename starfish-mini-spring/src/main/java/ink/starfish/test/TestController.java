package ink.starfish.test;

import ink.starfish.mvc.annotation.MyController;
import ink.starfish.mvc.annotation.MyRequestMapping;
import ink.starfish.mvc.annotation.MyRequestParam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@MyController
@MyRequestMapping("/test")
public class TestController {

    @MyRequestMapping("/query")
    public void test1(HttpServletRequest request, HttpServletResponse response,
                      @MyRequestParam("param") String param) {
        System.out.println(param);
        try {
            response.getWriter().write("query method success! param:" + param);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
