package pl.kryk.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.kryk.data.domain.User;

/**
 * Created by kryk on 19.07.2016.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByNickname(String nickname);

/**
 *
 * List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);

 // Enables the distinct flag for the query
 List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
 List<Person> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);

 // Enabling ignoring case for an individual property
 List<Person> findByLastnameIgnoreCase(String lastname);
 // Enabling ignoring case for all suitable properties
 List<Person> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);

 // Enabling static ORDER BY for a query
 List<Person> findByLastnameOrderByFirstnameAsc(String lastname);
 List<Person> findByLastnameOrderByFirstnameDesc(String lastname);


 Page<User> findByLastname(String lastname, Pageable pageable);

 Slice<User> findByLastname(String lastname, Pageable pageable);

 List<User> findByLastname(String lastname, Sort sort);

 List<User> findByLastname(String lastname, Pageable pageable);




 User findFirstByOrderByLastnameAsc();

 User findTopByOrderByAgeDesc();

 Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);

 Slice<User> findTop3ByLastname(String lastname, Pageable pageable);

 List<User> findFirst10ByLastname(String lastname, Sort sort);

 List<User> findTop10ByLastname(String lastname, Pageable pageable);

 @Query("select u from User u")
 Stream<User> findAllByCustomQueryAndStream();

 Stream<User> readAllByFirstnameNotNull();

 @Query("select u from User u")
 Stream<User> streamAllPaged(Pageable pageable);



 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

}
