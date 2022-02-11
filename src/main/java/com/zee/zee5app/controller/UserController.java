package com.zee.zee5app.controller;

import java.lang.StackWalker.Option;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.PastOrPresent;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.payload.request.LoginRequest;
import com.zee.zee5app.payload.request.SignupRequest;
import com.zee.zee5app.payload.response.JwtResponse;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.security.jwt.JwtUtils;
import com.zee.zee5app.security.services.UserDetailsImpl;
import com.zee.zee5app.service.UserService;

@RestController //combination of @ResponseBody and @Controller
//REST API: RESPONSE whenever we send a response 
//must be marked with @Response
//Not scalable
@RequestMapping("/api/auth")
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginRequest.getUsername(),
				loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateToken(authentication);
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
		
		List<String> roles = userDetailsImpl.getAuthorities()
				.stream()
				.map(i->i.getAuthority())
				.collect(Collectors.toList());
		
		
		return ResponseEntity.ok(new JwtResponse(jwt, 
				userDetailsImpl.getId(), 
				userDetailsImpl.getUsername(), 
				userDetailsImpl.getEmail(), 
				roles));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest){
		
		if(userRepository.existsByUsername(signupRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is taken!"));
		}
		if (userRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: email is already in use!"));
		}
		
		//user account creation
		User user= new User(signupRequest.getUsername(), signupRequest.getFirstName(), signupRequest.getLastName(),
				signupRequest.getEmail(), passwordEncoder.encode(signupRequest.getPassword()));
		
		// retrieving the role details
		Set<String> strRoles= signupRequest.getRole();
		Set<Role> roles = new HashSet<>();
		
		if(strRoles == null) {
			Role userRole = roleRepository.findByRoleName(EROLE.ROLE_USER)
					.orElseThrow(()->new RuntimeException("Error: role not found"));
			roles.add(userRole);
		}
		
		else {
			strRoles.forEach(e->{
				switch (e) {
				case "admin":
					Role roleAdmin = roleRepository.findByRoleName(EROLE.ROLE_ADMIN)
							.orElseThrow(()->new RuntimeException("Error: role not found"));
					roles.add(roleAdmin);
					break;
					
				case "mod":
					Role roleMod = roleRepository.findByRoleName(EROLE.ROLE_MODERATOR)
							.orElseThrow(()->new RuntimeException("Error: role not found"));
					roles.add(roleMod);
					break;
				
				default:
					Role userRole = roleRepository.findByRoleName(EROLE.ROLE_USER)
							.orElseThrow(()->new RuntimeException("Error: role not found"));
					roles.add(userRole);
					break;
				}
			});
			
			
			
		}
		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.status(201).body(new MessageResponse("user created successfully"));
	}
	
	
	
	//adding user info into table
	//info shared by client through JSON object
	//JSON object is present in the requestbody of the client request
	//@RequestBody transforms the JSON object to Java object
//	@PostMapping("/addUser")
//	public ResponseEntity<?> addUser(@Valid @RequestBody User register) throws AlreadyExistsException {
//		//should store the information into DB
//		//validation
//		//return crispy info to the client
//		//customization in error response
//		//declaration og custom exceptions
//		 
//			User result = userService.addUser(register);
//			System.out.println(result);
//			return ResponseEntity.status(201).body(result);
//		
//		//return register.toString();
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<?> getUserById(@PathVariable("id") String id) throws IdNotFoundException{
//		Optional<User> result = userService.getUserById(id);
//		return ResponseEntity.ok(result);
//	}
//	
//	@GetMapping("/all")
//	public ResponseEntity<?> getAllUserDetails(){
//		Optional<List<User>> optional = userService.getAllUserDetails();
//		if (optional.isEmpty()) {
////			Map<String, String> map = new HashMap<>();
////			map.put("message","no record found");
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("no record found"));
//		}
//		return ResponseEntity.ok(optional.get());
//	}
	
	
}
