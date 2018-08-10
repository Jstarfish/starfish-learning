package priv.starfish.entity;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import priv.starfish.ApplicationTests;
import priv.starfish.repository.UserRepository;

import java.util.Optional;

public class UserRepositoryTest extends ApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne() {
        Optional<User> user = userRepository.findById(1L);
        Assert.assertEquals("star", user.get().getName());
    }
}
