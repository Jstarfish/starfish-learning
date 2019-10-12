package priv.starfish.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.starfish.system.dao.UserDao;
import priv.starfish.system.form.UserForm;
import priv.starfish.system.model.User;
import priv.starfish.system.service.UserService;

import java.util.List;

/**
 * Created by starfish on 2017/8/21.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserInfo(String username) {
        return userDao.getUserInfo(username);
    }

    public List<User> getAllUsers(UserForm form) {
        return userDao.getAllUsers(form);
    }
}
