package com.zee.zee5app.controller;

import java.lang.StackWalker.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.UserService;

@RestController //combination of @ResponseBody and @Controller
//REST API: RESPONSE whenever we send a response 
//must be marked with @Response
//Not scalable
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	//adding user info into table
	//info shared by client through JSON object
	//JSON object is present in the requestbody of the client request
	//@RequestBody transforms the JSON object to Java object
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@Valid @RequestBody Register register) throws AlreadyExistsException {
		//should store the information into DB
		//validation
		//return crispy info to the client
		//customization in error response
		//declaration og custom exceptions
		 
			Register result = userService.addUser(register);
			System.out.println(result);
			return ResponseEntity.status(201).body(result);
		
		//return register.toString();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") String id) throws IdNotFoundException{
		Register result = userService.getUserById(id);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllUserDetails(){
		Optional<List<Register>> optional = userService.getAllUserDetails();
		if (optional.isEmpty()) {
			Map<String, String> map = new HashMap<>();
			map.put("message","no record found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());
	}
	
}
