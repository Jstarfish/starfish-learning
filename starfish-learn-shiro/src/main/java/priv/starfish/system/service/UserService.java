package priv.starfish.system.service;



import priv.starfish.system.form.UserForm;
import priv.starfish.system.model.User;

import java.util.List;

/**
 * Created by starfish on 2017/8/21.
 */
public interface UserService {

    User getUserInfo(String username);

    List<User> getAllUsers(UserForm form);
}
