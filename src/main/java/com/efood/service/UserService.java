package com.efood.service;

import java.util.List;

import com.efood.dto.ResponseDTO;
import com.efood.model.User;

/**
 * Created by fan.jin on 2016-10-15.
 */
public interface UserService {
//    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
    ResponseDTO<User> save(User user);
}
