package com.eugene.userlist.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.eugene.userlist.validation.ValidDate;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
	private String id;
	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	@NotEmpty(message = "Email cannot be empty")
	private String email;
	@Size(min=8)
	@NotEmpty(message = "Password cannot be empty")
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
	private String password;
	@NotEmpty(message = "Name cannot be empty")
	@Pattern(regexp="^[A-Za-z ]+$")
	private String fullName;
	@ValidDate(minAge=14)
	private LocalDate birthDate;
	
}
