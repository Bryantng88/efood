package com.bfwg.repository;

import java.util.List;

import com.bfwg.model.Authority;
import com.bfwg.model.User;
import com.bfwg.model.EUserRoleName;

/**
 * Created by fan.jin on 2016-10-15.
 */
public interface UserRepository {
    User findByUsername( String username );
    User findByUserEmail( String email);
    List<User> findAll();
    User save(User user);
    Authority findAuthority(EUserRoleName eUserRoleName);
}

