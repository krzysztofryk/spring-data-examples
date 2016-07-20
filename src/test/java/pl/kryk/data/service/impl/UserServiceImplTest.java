package pl.kryk.data.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import pl.kryk.data.domain.User;
import pl.kryk.data.service.UserService;

import java.util.Optional;

/**
 * Created by kryk on 19.07.2016.
 */
public class UserServiceImplTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Autowired
    private CrudRepository<User, Long> repository;

    //TODO: Spock Spring

    @Test
    public void getUserByNickname() {

        String nickname = "krzysztof";
        User user = new User();
        user.setNickname(nickname);

        repository.save(user);

        Optional<User> result = userService.getByNickname(nickname);

        Assert.assertTrue(result.isPresent());
        Assert.assertEquals(nickname, result.get().getNickname());

    }


}
