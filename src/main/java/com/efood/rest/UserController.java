package com.efood.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.efood.common.MessageConst;
import com.efood.dto.ResponseDTO;
import com.efood.dto.UserDTO;
import com.efood.dto.UserRequestDTO;
import com.efood.model.User;
import com.efood.service.UserService;

/**
 * Created by fan.jin on 2016-10-15.
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping( method = GET, value = "/user/{userId}" )
//    @PreAuthorize("hasRole('ADMIN')")
//    public User loadById( @PathVariable Long userId ) {
//        return this.userService.findById( userId );
//    }

    @RequestMapping( method = GET, value= "/user/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> loadAll() {
        return this.userService.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(method = RequestMethod.POST, value = "no-auth/user/add")
    public ResponseEntity<ResponseDTO<UserDTO>> save(@RequestBody UserRequestDTO userRequestDTO) {
    	ResponseDTO<UserDTO> response = new ResponseDTO<UserDTO>();    	
    	try {
    		User user = userRequestDTO.toUser();
    		ResponseDTO<User> userResult = this.userService.save(user);
    		
    		//if user successfully saved to database, make a copy to userDTO
    		if(userResult.getData() != null) {
    			System.out.println("successfully registered! ");// lo4j
    			UserDTO userDTO = new UserDTO();
    			userDTO.copyFrom(userResult.getData());
    			response.setData(userDTO);
    		}else {
    			response.setErrorMessage(userResult.getErrorMessage());
        		System.out.println("there is error: " + response.getErrorMessage());
    			return new ResponseEntity<ResponseDTO<UserDTO>>(response, HttpStatus.BAD_REQUEST);
    		}    		
    	}catch (IllegalArgumentException e) {
    		response.setErrorMessage(MessageConst.ERROR_ROLE_INVALID);
    	}
    	return new ResponseEntity<ResponseDTO<UserDTO>>(response, HttpStatus.OK);
    }
    
    /*
     *  We are not using userService.findByUsername here(we could),
     *  so it is good that we are making sure that the user has role "ROLE_USER"
     *  to access this endpoint.
     */
    @RequestMapping("/whoami")
    @PreAuthorize("hasRole('USER')")
    public UserDTO user(Principal user) {
    	User userRes = this.userService.findByUsername(user.getName());
    	UserDTO userDTO = new UserDTO();
    	userDTO.copyFrom(userRes);
        return userDTO;
    }
}
