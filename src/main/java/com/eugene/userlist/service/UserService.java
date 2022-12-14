package com.eugene.userlist.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.userlist.domain.User;
import com.eugene.userlist.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	

	//Could be done with query or specification
	public List<User> getUserList(LocalDate dateFrom, LocalDate dateTo, String email) {
		if(email != null)
			email = "%" + email.trim() + "%";
		if(dateFrom != null)
			if(dateTo != null)
				if(email!=null)
					return repo.findAllByBirthDateGreaterThanAndBirthDateLessThanAndEmailLike(dateFrom, dateTo, email);
				else
					return repo.findAllByBirthDateGreaterThanAndBirthDateLessThan(dateFrom, dateTo);
			else
				if(email != null)
					return repo.findAllByBirthDateGreaterThanAndEmailLike(dateFrom, email);
				else
					return repo.findAllByBirthDateGreaterThan(dateFrom);
		else
			if(dateTo != null)
				if(email != null)
					return repo.findAllByBirthDateLessThanAndEmailLike(dateTo, email);
				else
					return repo.findAllByBirthDateLessThan(dateTo);
			else
				if(email != null)
					return repo.findAllByEmailLike(email);
				else
					return repo.findAll();
	}
	
	public User save(@Valid User user) {
		return repo.save(user);
	}

	public User getUserById(String id) {
		Optional<User> user = repo.findById(id);
		return user.isPresent() ? user.get() : null;
	}
	
	public User updateUser(@Valid User user, String id) {
		Optional<User> toUpdate = repo.findById(id);
		if(toUpdate.isPresent()) {
			user.setId(toUpdate.get().getId());
			return save(user);
		}else
			return null;
	}
	
	public void delete(User user) {
		repo.delete(user);
	}

	public void deleteById(String id) {
		Optional<User> toDelete = repo.findById(id);
		if(toDelete.isPresent()) 
			delete(toDelete.get());
		
	}
}
