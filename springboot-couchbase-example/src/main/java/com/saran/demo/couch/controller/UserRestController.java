package com.saran.demo.couch.controller;

import java.io.IOException;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saran.demo.couch.controller.dto.UserDTO;
import com.saran.demo.couch.service.UserService;
import com.saran.demo.couch.view.User;

@RestController
public class UserRestController {

	@Autowired
	UserService userService;

	@Autowired
	ObjectMapper objectMapper;

	@RequestMapping(path = "/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public String saveUser(@RequestBody String request) {
		UserDTO dto = null;
		String responseJson = null;
		try {
			dto = objectMapper.readValue(request, UserDTO.class);
			User response = userService.saveUser(dto);
			// convert Object o JSON
			responseJson = objectMapper.writeValueAsString(response);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return responseJson;
	}

	@RequestMapping(path = "/findAll", method = RequestMethod.GET, produces = "application/json")
	public List<UserDTO> findAll() {
		return userService.findAll();
	}

	@RequestMapping(path = "/delete")
	public UserDTO deleteUser(@RequestParam("id") String id) {
		return userService.deleteUser(id);
	}
}
