package pl.kryk.data.domain;

import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by kryk on 19.07.2016.
 */
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String nickname;

    @NotEmpty
    private String email;

    private boolean active;

    @NonNull
    private UserType userType = UserType.INTERNAL;

}
