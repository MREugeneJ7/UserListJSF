package com.eugene.userlist.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.eugene.userlist.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> , JpaSpecificationExecutor<User>{

	List<User> findAllByBirthDateGreaterThan(LocalDate dateFrom);

	List<User> findAllByBirthDateLessThan(LocalDate dateTo);

	List<User> findAllByBirthDateGreaterThanAndBirthDateLessThan(LocalDate dateFrom, LocalDate dateTo);

	List<User> findAllByBirthDateGreaterThanAndBirthDateLessThanAndEmailLike(LocalDate dateFrom, LocalDate dateTo,
			String email);

	List<User> findAllByBirthDateGreaterThanAndEmailLike(LocalDate dateFrom, String email);

	List<User> findAllByBirthDateLessThanAndEmailLike(LocalDate dateTo, String email);

	List<User> findAllByEmailLike(String email);

}
