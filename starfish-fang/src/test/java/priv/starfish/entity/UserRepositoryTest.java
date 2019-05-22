package priv.starfish.entity;

import com.google.common.io.ByteSource;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import priv.starfish.ApplicationTests;
import priv.starfish.repository.UserRepository;

public class UserRepositoryTest extends ApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne() {
        User user = userRepository.findOne(1L);
        Assert.assertEquals("star", user.getName());
        //Optional<User> user = userRepository.findById(1L);
        //Assert.assertEquals("star", user.get().getName());
    }




//    private String encrypt(String username,String password) {
//        String hashAlgorithmName = "MD5";
//        Object salt = ByteSource.Util.bytes(username);
//        int hashIterations = 1024;
//        Object result = new SimpleHash(hashAlgorithmName, password, salt, hashIterations);
//        // System.out.println(result);
//        return result.toString();
//    }
}
