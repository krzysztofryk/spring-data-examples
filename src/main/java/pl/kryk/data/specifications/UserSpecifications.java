package pl.kryk.data.specifications;

import org.springframework.data.jpa.domain.Specification;
import pl.kryk.data.domain.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by kryk on 20.07.16.
 */
public final class UserSpecifications {

	public static final String NICKNAME = "nickname";

	private UserSpecifications() {

	}

	public static Specification<User> getByNickname(String nickname) {
		return new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<String> get(NICKNAME), nickname);
			}
		};
	}
}
