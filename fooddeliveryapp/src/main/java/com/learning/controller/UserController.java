package com.learning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.Login;
import com.learning.dto.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.service.LoginService;
import com.learning.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@Valid @RequestBody Register register) throws AlreadyExistsException{
		Register result = userService.addUser(register);
		System.out.println(result);
		return ResponseEntity.status(201).body(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") int id) throws IdNotFoundException{
		Register result = userService.getUserById(id);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAllUserDetails(){
		Optional<List<Register>> optional = userService.getAllUserDetails();
		if (optional.isEmpty()) {
			Map<String, String> map = new HashMap<>();
			map.put("message","no record found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") int id) throws IdNotFoundException{
		String result = userService.deleteUserById(id);
		System.out.println(result);
		if( result=="successfully deleted user") {
			System.out.println("tets1");
			Map<String, String> map = new HashMap<>();
			map.put("message","User deleted successfully");
			System.out.println(map);
			return ResponseEntity.ok(map);
		}
		else {
			Map<String, String> map = new HashMap<>();
			map.put("message","Sorry no user found");
			return ResponseEntity.status(500).body(map);
		}
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticateUser(@RequestBody Login login){
		String result = loginService.vaidateCredentials(login);
		Map<String, String> map = new HashMap<>();
		if(result.equals("successfully validated")) {
			return ResponseEntity.status(201).body(result);
        
		}
		return ResponseEntity.status(200).body(result);
	
	}
	
//	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody Register register) throws IdNotFoundException
	{
		Register result = userService.updateUser(id, register);
		return ResponseEntity.status(201).body(result);
	}
}
