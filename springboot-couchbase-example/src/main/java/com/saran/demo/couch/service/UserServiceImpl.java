package com.saran.demo.couch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saran.demo.couch.controller.dto.UserDTO;
import com.saran.demo.couch.repository.UserRepository;
import com.saran.demo.couch.view.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(UserDTO request) {
		User user = new User();
		user.setId(request.getId());
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		User response = userRepository.save(user);
		return response;
	}

	public List<UserDTO> findAll() {
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		List<User> response = userRepository.findAll();
		for (User user : response) {
			UserDTO dto = new UserDTO();
			dto.setFirstName(user.getFirstName());
			dto.setLastName(user.getLastName());
			userDTOList.add(dto);
		}
		return userDTOList;
	}

	@Override
	public UserDTO deleteUser(String id) {

		User user = userRepository.deleteById(id);
		// convert Document to DTO
		UserDTO dto = new UserDTO();
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		return dto;
	}

}
