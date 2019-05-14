package com.efood.repository;

import java.util.List;

import com.efood.model.Authority;
import com.efood.model.EUserRoleName;
import com.efood.model.User;

/**
 * Created by fan.jin on 2016-10-15.
 */
public interface UserRepository {
    User findByUsername( String username );
    User findByUserEmail( String email);
    List<User> findAll();
    User save(User user);
    Authority findAuthority(EUserRoleName eUserRoleName);
	List<Authority> findAuthorities(List<EUserRoleName> roleNames);
}

