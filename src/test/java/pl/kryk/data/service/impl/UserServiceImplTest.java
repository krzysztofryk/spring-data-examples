package pl.kryk.data.service.impl;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import pl.kryk.data.domain.User;
import pl.kryk.data.domain.UserType;
import pl.kryk.data.service.UserService;

import java.util.List;
import java.util.Optional;

/**
 * Created by kryk on 19.07.2016.
 */
public class UserServiceImplTest extends BaseTest {

	@Autowired
	private UserService userService;

	@Autowired
	private CrudRepository<User, Long> repository;

	private User user1;

	private User user2;

	private User user3;

	// TODO: Spock Spring

	@Before
	public void setUp() {
		String nickname1 = "krzysztof";
		String email1 = "krzysztof@ryk.com";

		user1 = new User();
		user1.setNickname(nickname1);
		user1.setEmail(email1);
		user1.setActive(true);
		user1.setUserType(UserType.INTERNAL);

		user1 = repository.save(user1);

		String nickname2 = "janusz";
		String email2 = "janusz@ryk.com";

		user2 = new User();
		user2.setNickname(nickname2);
		user2.setEmail(email2);
		user2.setActive(true);
		user2.setUserType(UserType.EXTERNAL);

		user2 = repository.save(user2);

		String nickname3 = "piotrek";
		String email3 = "piotrek@ryk.com";

		user3 = new User();
		user3.setNickname(nickname3);
		user3.setEmail(email3);
		user3.setActive(false);
		user3.setUserType(UserType.EXTERNAL);

		user3 = repository.save(user3);
	}

	@After
	public void tearDown() {
		repository.delete(user1);
		repository.delete(user2);
		repository.delete(user3);
	}

	@Test
	public void getUserByNickname() {
		String nickname = user1.getNickname();

		Optional<User> result = userService.getByNickname(nickname);

		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(nickname, result.get().getNickname());
	}

	@Test
	public void getByEmailOrNickname() {

		String fakeNickname = "fake";
		String email = user1.getEmail();
		String nickname = user1.getNickname();
		User result = userService.getByEmailOrNickname(email, fakeNickname);

		Assert.assertNotNull(result);
		Assert.assertEquals(nickname, result.getNickname());
		Assert.assertEquals(email, result.getEmail());

		String fakeEmail = "fake";
		result = userService.getByEmailOrNickname(fakeEmail, nickname);

		Assert.assertNotNull(result);
		Assert.assertEquals(nickname, result.getNickname());
		Assert.assertEquals(email, result.getEmail());
	}

	@Test
	public void getByEmailAndNickname() {
		String email = user1.getEmail();
		String nickname = user1.getNickname();
		User result = userService.getByEmailAndNickname(email, nickname);

		Assert.assertNotNull(result);
		Assert.assertEquals(nickname, result.getNickname());
		Assert.assertEquals(email, result.getEmail());

		String fakeEmail = "fake";
		result = userService.getByEmailAndNickname(fakeEmail, nickname);

		Assert.assertNull(result);
	}

	@Test
	public void getByNicknameIgnoreCase() {
		String nickname = user1.getNickname().toUpperCase();

		User result = userService.getByNicknameIgnoreCase(nickname);

		Assert.assertNotNull(result);
		Assert.assertEquals(nickname.toLowerCase(), result.getNickname().toLowerCase());
	}

	@Test
	public void findByActiveTrueAndUserType() {
		List<User> result = userService.findByActiveTrueAndUserType(UserType.INTERNAL);

		Assert.assertNotNull(result);
		Assert.assertEquals(1, result.size());
		Assert.assertEquals(user1, result.get(0));
	}

	@Test
	public void findByActiveTrueOrderByNicknameAsc() {
		List<User> result = userService.findByActiveTrueOrderByNicknameAsc();

		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.size());
		Assert.assertEquals(user2.getNickname(), result.get(0).getNickname());
		Assert.assertEquals(user1.getNickname(), result.get(1).getNickname());
	}

	@Test
	public void queryFirst10ByNickname() {

	}

	@Test
	public void findBySqlQueryAndStream() {

	}

}
