package com.efood.dto;

import java.util.ArrayList;
import java.util.List;

import com.efood.model.Authority;
import com.efood.model.EUserRoleName;
import com.efood.model.EUserType;
import com.efood.model.User;

public class UserRequestDTO {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String userType;
	private String phoneNumber;
	private String address;
	private String avatar;
	private List<String> authorities = new ArrayList<String>();
	
	public User toUser() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		user.setAddress(address);
		
		if (this.getUserType() == null) {
			user.seteUserType(EUserType.CUSTOMER);
		}else {
			user.seteUserType(EUserType.valueOf(this.getUserType()));
		}
		
		if (this.getAuthorities()==null || this.getAuthorities().isEmpty()) {
			Authority authorites = new Authority();
				authorites.setName(EUserRoleName.ROLE_USER);
				user.getAuthorities().add(authorites);			
		}else {
			for (String roleName : this.getAuthorities()) {
				Authority authorities = new Authority();
				authorities.setName(EUserRoleName.valueOf(roleName));
				user.getAuthorities().add(authorities);
			}
		}
		return user;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		StringBuffer strDto = new StringBuffer();
		strDto.append("User Info:\nUsername: ").append(this.username).append("\nPassword: ").append(this.password)
				.append("\nfirstName: ").append(this.firstName).append("\nlastName: ").append(this.lastName)
				.append("\nemail: ").append(this.email).append("\nphoneNumber: ").append(this.phoneNumber)
				.append("\navatar: ").append(this.avatar).append("\nroles: ").append(this.authorities);
		return strDto.toString();
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<String> getAuthorities() {
		return authorities;
	}
}
