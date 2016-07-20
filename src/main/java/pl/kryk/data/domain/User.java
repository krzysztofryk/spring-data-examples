package pl.kryk.data.domain;

import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kryk on 19.07.2016.
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	private String nickname;

	@NotEmpty
	private String email;

	private boolean active;

	@NonNull
	private UserType userType = UserType.INTERNAL;

	@CreatedDate
	private Date createdDate;

	@LastModifiedDate
	private Date modifiedDate;

	@CreatedBy
	private String createdBy;

	@LastModifiedBy
	private String lastModifiedBy;

	@Version
	private long version = 0;

}
