package com.dichvudulich.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dichvudulich.models.LoaitintucEntity;
import com.dichvudulich.repository.LoaiTintucRepository;
import com.dichvudulich.repository.RoleRepository;
import com.dichvudulich.security.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class LoaiTintucController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	LoaiTintucRepository loaiTintucRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@GetMapping("/loaitintuc/{id}")
	public ResponseEntity<Optional<LoaitintucEntity>> getLoaiTintucById(@PathVariable Long id) {
		Optional<LoaitintucEntity> user = loaiTintucRepository.findById(id);
		return ResponseEntity.ok(user);
	}

}
