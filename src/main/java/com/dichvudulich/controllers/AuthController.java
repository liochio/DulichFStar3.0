package com.dichvudulich.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dichvudulich.models.ERole;
import com.dichvudulich.models.Role;
import com.dichvudulich.models.User;
import com.dichvudulich.payload.request.LoginRequest;
import com.dichvudulich.payload.request.SignupRequest;
import com.dichvudulich.payload.response.JwtResponse;
import com.dichvudulich.payload.response.MessageResponse;
import com.dichvudulich.repository.RoleRepository;
import com.dichvudulich.repository.UserRepository;
import com.dichvudulich.security.jwt.JwtUtils;
import com.dichvudulich.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, HttpServletRequest request) {

	    try {
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        String jwt = jwtUtils.generateJwtToken(authentication);

	        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
	        List<String> roles = userDetails.getAuthorities().stream()
	                .map(item -> item.getAuthority())
	                .collect(Collectors.toList());

	        Map<String, Object> response = new HashMap<>();
	        	   
	        
	        // Populate header section
//	        Map<String, Object> header = new HashMap<>();
//	        header.put("request_type", request.getMethod());
//	        header.put("request_id", generateRequestId()); // You need to implement this method
//	        header.put("href", "/api/auth/signin");
//	        header.put("timestamp", generateTimestamp()); // You need to implement this method
//	        response.put("header", header);

	        
	        Map<String, Object> result = new HashMap<>();
	        result.put("code", "00");
	        result.put("message", "success");
	        result.put("description", "Authentication successful");
	        response.put("result", result);

	        
	        Map<String, Object> data = new HashMap<>();
	        data.put("jwt", jwt);
	        data.put("id", userDetails.getId());
	        data.put("username", userDetails.getUsername());
	        data.put("email", userDetails.getEmail());
	        data.put("roles", roles);
	        response.put("data", data);

	        return ResponseEntity.ok(response);

	    } catch (Exception e) {
	        Map<String, Object> response = new HashMap<>();
	        Map<String, Object> header = new HashMap<>();
	        header.put("request_type", request.getMethod());
	        header.put("request_id", generateRequestId());
	        header.put("href", "/api/auth/signin");
	        header.put("timestamp", generateTimestamp());
	        response.put("header", header);

	        Map<String, Object> result = new HashMap<>();
	        result.put("code", "01");
	        result.put("message", "error");
	        result.put("description", "Authentication failed: " + e.getMessage());
	        response.put("result", result);

	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	    }
	}
  
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest,HttpServletRequest request) {
	    try {
	        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	            return ResponseEntity
	                .badRequest()
	                .body(new MessageResponse("Error: Username is already taken!"));
	        }

	        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
	            return ResponseEntity
	                .badRequest()
	                .body(new MessageResponse("Error: Email is already in use!"));
	        }

	        // Create new user's account
	        User user = new User(signUpRequest.getUsername(),
	                             signUpRequest.getEmail(),
	                             encoder.encode(signUpRequest.getPassword()));

	        Set<String> strRoles = signUpRequest.getRole();
	        Set<Role> roles = new HashSet<>();

	        if (strRoles == null) {
	            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	            roles.add(userRole);
	        } else {
	            strRoles.forEach(role -> {
	                switch (role) {
	                    case "admin":
	                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
	                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	                        roles.add(adminRole);
	                        break;
	                    case "mod":
	                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
	                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	                        roles.add(modRole);
	                        break;
	                    default:
	                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	                        roles.add(userRole);
	                }
	            });
	        }

	        user.setRoles(roles);
	        userRepository.save(user);

	        Map<String, Object> response = new HashMap<>();

//	        Map<String, Object> header = new HashMap<>();
//	        header.put("request_type", "POST");
//	        header.put("request_id", generateRequestId());
//	        header.put("href", "/api/auth/register");
//	        header.put("timestamp", generateTimestamp());
//	        response.put("header", header);

	        Map<String, Object> result = new HashMap<>();
	        result.put("code", "00");
	        result.put("message", "success");
	        result.put("description", "User registered successfully");
	        response.put("result", result);
	        
	        
	        Map<String, Object> data = new HashMap<>();
	        data.put("username", signUpRequest.getUsername());
	        data.put("email", signUpRequest.getEmail());
	        data.put("password", signUpRequest.getPassword());
	        data.put("roles", roles);
	        response.put("data", data);

	        return ResponseEntity.ok(response);

	    } catch (RuntimeException e) {
	        Map<String, Object> response = new HashMap<>();
	        Map<String, Object> header = new HashMap<>();
	        header.put("request_type", request.getMethod());
	        header.put("request_id", generateRequestId()); 
	        header.put("href", "/api/auth/register");
	        header.put("timestamp", generateTimestamp());
	        response.put("header", header);

	        Map<String, Object> result = new HashMap<>();
	        result.put("code", "01");
	        result.put("message", "error");
	        result.put("description", "User registration failed: " + e.getMessage());
	        response.put("result", result);

	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}
  
	private String generateRequestId() {
	    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
	}

	private String generateTimestamp() {
	    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
	}

}
