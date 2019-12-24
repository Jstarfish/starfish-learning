package priv.starfish.system.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.starfish.system.form.UserForm;
import priv.starfish.system.model.User;
import priv.starfish.system.service.UserService;

import java.util.List;


/**
 * Created by starfish on 2017/8/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(params = "method=getUserList")
    public String getUserList(){
        return "system/user/userList";
    }

    @ResponseBody
    @RequestMapping(params = "method=listUsers")
    public Object listUsers(UserForm form) {
        List<User> user = userService.getAllUsers(form);
        return user;
    }
}
