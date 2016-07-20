package pl.kryk.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kryk.data.domain.User;
import pl.kryk.data.repository.UserRepository;
import pl.kryk.data.service.UserService;

import java.util.Optional;

/**
 * Created by kryk on 19.07.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getByNickname(String nickname) {
        return Optional.ofNullable(userRepository.findByNickname(nickname));
    }
}
