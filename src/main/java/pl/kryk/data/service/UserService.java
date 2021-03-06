package pl.kryk.data.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.kryk.data.domain.User;
import pl.kryk.data.domain.UserType;

import java.util.List;
import java.util.Optional;

/**
 * Created by kryk on 19.07.2016.
 */
public interface UserService {

	Optional<User> getByNickname(String nickname);

	User getByEmailOrNickname(String email, String nickname);

	User getByEmailAndNickname(String email, String nickname);

	User getByNicknameIgnoreCase(String nickname);

	List<User> findByActiveTrueAndUserType(UserType userType);

	List<User> findByActiveTrueOrderByNicknameAsc();

	Page<User> findByUserTypeOrderByNicknameDesc(UserType userType, Pageable pageable);

	List<User> findAllBySqlQuery();

	User getByNicknameUsingSpec(String nickname);

}
