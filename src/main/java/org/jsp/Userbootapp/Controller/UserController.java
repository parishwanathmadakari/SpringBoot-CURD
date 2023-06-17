package org.jsp.Userbootapp.Controller;

import java.util.Optional;

import org.jsp.Userbootapp.DTO.Responsestructure;
import org.jsp.Userbootapp.DTO.User;
import org.jsp.Userbootapp.Service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	Service service;

	@PostMapping("/user")
	public ResponseEntity<Responsestructure<User>> saveUser(@RequestBody User user) {

		return service.saveUser(user);

	}

	@PutMapping("/user")
	public ResponseEntity<Responsestructure<User>> updateUser(@RequestBody User user) {

		return service.UpdateUser(user);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<Responsestructure<User>> finduser(@PathVariable int id) {

		return service.finduser(id);

	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Responsestructure<String>> Deleteuser(@PathVariable int id) {

		return service.Deleteuser(id);

	}

	@PostMapping("/user/verify")
	public ResponseEntity<Responsestructure<User>> verifyUser(@RequestParam long phone, @RequestParam String email) {
		return service.verifyuser(phone, email);
	}
}
