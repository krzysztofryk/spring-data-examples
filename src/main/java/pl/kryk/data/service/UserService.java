package pl.kryk.data.service;

import pl.kryk.data.domain.User;

import java.util.Optional;

/**
 * Created by kryk on 19.07.2016.
 */
public interface UserService {

    Optional<User> getByNickname(String nickname);

}
