package pl.kryk.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.kryk.data.domain.User;
import pl.kryk.data.domain.UserType;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by kryk on 19.07.2016.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {

    User getByNickname(String nickname);

    User getByEmailOrNickname(String email, String nickname);

    User getByEmailAndNickname(String email, String nickname);

    User getByNicknameIgnoreCase(String nickname);

    List<User> findByActiveTrueAndUserType(UserType userType);

    List<User> findByActiveTrueOrderByNicknameAsc();

    Page<User> findByUserTypeOrderByNicknameDesc(UserType userType, Pageable pageable);

    @Query("select u from User u")
    List<User> findAllBySqlQuery();

}
