package com.saran.demo.couch.service;

import java.util.List;

import com.saran.demo.couch.controller.dto.UserDTO;
import com.saran.demo.couch.view.User;

public interface UserService {

	User saveUser(UserDTO request);

	List<UserDTO> findAll();

	UserDTO deleteUser(String name);

}
