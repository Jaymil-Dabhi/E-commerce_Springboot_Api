package com.example.service;

import com.example.exception.UserException;
import com.example.model.User;

public interface UserService {

<<<<<<< HEAD
	public User findUserById(Long userId) throws UserException;
=======
	public User findUserByUd(Long userId) throws UserException;
>>>>>>> b85a357c66aeb8ae99b89a940ff6945a4067f389
	
	public User findUserProfileByJwt(String jwt) throws UserException;
}
