package com.efood.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.efood.common.MessageConst;
import com.efood.common.RegexMatcher;
import com.efood.dto.ResponseDTO;
import com.efood.model.Authority;
import com.efood.model.EUserRoleName;
import com.efood.model.User;
import com.efood.repository.UserRepository;
import com.efood.service.UserService;

/**
 * Created by fan.jin on 2016-10-15.
 */

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User findByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	public List<User> findAll() throws AccessDeniedException {
		return userRepository.findAll();
	}

	@Override
	public ResponseDTO<User> save(User user) {
		ResponseDTO<User> response = new ResponseDTO<User>();
		boolean isValid = validate(user, response);
		Authority authority = new Authority();
		if (isValid) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setEnabled(true);
			if (user.getAuthorities().size() <= 1) {
				authority = userRepository.findAuthority(EUserRoleName.ROLE_USER);
				user.getAuthorities().get(0).setId(authority.getId());
			} else {
				List<EUserRoleName> list = new ArrayList<EUserRoleName>();
				for (Authority autho : user.getAuthorities()) {
					list.add(autho.getName());
				}			
				List<Authority> authorities = userRepository.findAuthorities(list);
				user.setAuthorities(authorities);
			}
			try {
				User userResult = userRepository.save(user);
				response.setData(userResult);
			} catch (Exception e) {
				System.out.println("abc: " + e);
				Throwable t = e.getCause();
				if (t instanceof ConstraintViolationException) {
					response.setErrorMessage(MessageConst.ERROR_USER_EXISTS);
				}
			}
		}
	
		return response;
	}
	private boolean validate(User user, ResponseDTO<User> response) {
		User resultUserName = userRepository.findByUsername(user.getUsername());
		if (resultUserName.getId() != null) {
			response.setErrorMessage(MessageConst.ERROR_USER_EXISTS);
			return false;
		}
		User resultUserEmail = userRepository.findByUserEmail(user.getEmail());
		if (resultUserEmail.getId() != null) {
			response.setErrorMessage(MessageConst.ERROR_USER_EMAIL_EXISTS);
		}
		if (user.getPassword() == null || !RegexMatcher.isValidPassword(user.getPassword())) {
			response.setErrorMessage(MessageConst.ERROR_USER_PASSWORD);
			return false;
		}
		if (user.getFirstName() == null || !RegexMatcher.isValidName(user.getFirstName())) {
			response.setErrorMessage(MessageConst.ERROR_USER_FIRST_NAME);
			return false;
		}
		if (user.getLastName() == null || !RegexMatcher.isValidName(user.getLastName())) {
			response.setErrorMessage(MessageConst.ERROR_USER_LAST_NAME);
			return false;
		}
		if (user.getEmail() == null || !RegexMatcher.isValidEmail(user.getEmail())) {
			response.setErrorMessage(MessageConst.ERROR_USER_EMAIL);
			return false;
		}
		if (user.getPhoneNumber() == null || !RegexMatcher.isValidPhone(user.getPhoneNumber())) {
			response.setErrorMessage(MessageConst.ERROR_USER_PHONE);
			return false;
		}
		return true;
	}

}
