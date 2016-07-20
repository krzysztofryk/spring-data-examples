package pl.kryk.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kryk.data.domain.User;
import pl.kryk.data.domain.UserType;
import pl.kryk.data.repository.UserRepository;
import pl.kryk.data.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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
		return Optional.ofNullable(userRepository.getByNickname(nickname));
	}

	@Override
	@Transactional(readOnly = true)
	public User getByEmailOrNickname(String email, String nickname) {
		return userRepository.getByEmailOrNickname(email, nickname);
	}

	@Override
	@Transactional(readOnly = true)
	public User getByEmailAndNickname(String email, String nickname) {
		return userRepository.getByEmailAndNickname(email, nickname);
	}

	@Override
	@Transactional(readOnly = true)
	public User getByNicknameIgnoreCase(String nickname) {
		return userRepository.getByNicknameIgnoreCase(nickname);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findByActiveTrueAndUserType(UserType userType) {
		return userRepository.findByActiveTrueAndUserType(userType);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findByActiveTrueOrderByNicknameAsc() {
		return userRepository.findByActiveTrueOrderByNicknameAsc();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> findByUserTypeOrderByNicknameDesc(UserType userType, Pageable pageable) {
		return userRepository.findByUserTypeOrderByNicknameDesc(userType, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Stream<User> findBySqlQueryAndStream() {
		return userRepository.findBySqlQueryAndStream();
	}
}
