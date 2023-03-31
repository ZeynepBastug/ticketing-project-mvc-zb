package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;
    private String password;
    private boolean enabled;
    private Gender gender;
    private Role role;

    public User(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, String firstName, String lastName, String email, long phoneNumber, String password, boolean enabled, Gender gender, Role role) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.enabled = enabled;
        this.gender = gender;
        this.role = role;
    }
}
