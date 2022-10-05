package com.eugene.userlist.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.userlist.domain.User;
import com.eugene.userlist.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	

	//Could be done with query or specification
	public List<User> getUserList(String dateFrom, String dateTo, String email) {
		if(dateFrom != null)
			if(dateTo != null)
				if(email!=null && !email.trim().equals(""))
					return repo.findAllByBirthDateGreaterThanAndBirthDateLessThanAndEmailLike(LocalDate.parse(dateFrom), LocalDate.parse(dateTo), email);
				else
					return repo.findAllByBirthDateGreaterThanAndBirthDateLessThan(LocalDate.parse(dateFrom), LocalDate.parse(dateTo));
			else
				if(email != null && !email.trim().equals(""))
					return repo.findAllByBirthDateGreaterThanAndEmailLike(LocalDate.parse(dateFrom), email);
				else
					return repo.findAllByBirthDateGreaterThan(LocalDate.parse(dateFrom));
		else
			if(dateTo != null)
				if(email != null && !email.trim().equals(""))
					return repo.findAllByBirthDateLessThanAndEmailLike(LocalDate.parse(dateTo), email);
				else
					return repo.findAllByBirthDateLessThan(LocalDate.parse(dateTo));
			else
				if(email != null && !email.trim().equals(""))
					return repo.findAllByEmailLike(email);
				else
					return repo.findAll();
	}
}
