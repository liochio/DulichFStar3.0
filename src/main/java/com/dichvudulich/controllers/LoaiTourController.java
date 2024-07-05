package com.dichvudulich.controllers;

import Header.Header;
import Result.Result;
import com.dichvudulich.models.*;
import com.dichvudulich.pagination.PageUtils;
import com.dichvudulich.payload.request.LoaiTourEntityRequest;
import com.dichvudulich.payload.response.LoaiTourResponse;
import com.dichvudulich.payload.response.MessageResponse;
import com.dichvudulich.repository.LoaiTourRepository;
import com.dichvudulich.repository.OrderRepository;
import com.dichvudulich.repository.RoleRepository;
import com.dichvudulich.repository.UserRepository;
import com.dichvudulich.security.jwt.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class LoaiTourController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	LoaiTourRepository loaiTourRepository;

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	private FilesStorageService storageService;

	@Autowired
	private DatabaseFileService fileStorageService;



	@GetMapping("/loaitour/{id}")
	public ResponseEntity<Optional<LoaitourEntity>> getLoaitourById(@PathVariable Long id) {
		Optional<LoaitourEntity> loaitour = loaiTourRepository.findById(id);
		return ResponseEntity.ok(loaitour);
	}

	@GetMapping("/loaitour1")
	public ResponseEntity<List<LoaitourEntity>> getLoaitour() {
		List<LoaitourEntity> loaitour = loaiTourRepository.findByStatus();
		return ResponseEntity.ok(loaitour);
	}

	@GetMapping("/loaitour2")
	public ResponseEntity<?> getLoaitour2() {
		List<Order> loaitour = orderRepository.findAll();
		return ResponseEntity.ok(loaitour);
	}

	@GetMapping("/loaitour")
	public ResponseEntity<LoaiTourResponse<Page<LoaitourEntity>>> findAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size, HttpServletRequest request) {
		try {
			Pageable pageable = PageRequest.of(page, size);
			Page<LoaitourEntity> loaitourPage = loaiTourRepository.findAllByTrangThai(pageable);

			LoaiTourResponse<Page<LoaitourEntity>> response = new LoaiTourResponse<>();
			if (loaitourPage.isEmpty()) {
				response.setHeader(createHeader(request.getMethod()));
				response.setResult(createErrorResult(loaitourPage.getSize()));
				return ResponseEntity.ok(response);
			}

			response.setHeader(createHeader(request.getMethod()));
			response.setResult(createSuccessResult(loaitourPage.getSize()));
			response.setData(PageUtils.addIndexToPage(loaitourPage, page, size));
			return ResponseEntity.ok(response);
		} catch (Exception e) {
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
			return (ResponseEntity<LoaiTourResponse<Page<LoaitourEntity>>>) response;
		}

	}

	@PostMapping("/loaitour")
	public ResponseEntity<?> createLoaitour(@Valid @RequestBody LoaiTourEntityRequest loaiTourEntityRequest) {
		ModelMapper modelMapper = new ModelMapper();
		LoaitourEntity loaitour =  modelMapper.map(loaiTourEntityRequest, LoaitourEntity.class);
		loaiTourRepository.save(loaitour);
		return ResponseEntity.ok(new MessageResponse("Tour registered successfully!"));
	}

	@PutMapping("/loaitour/{id}")
	public ResponseEntity<LoaitourEntity> updateTutorial(@PathVariable("id") long id,
			@RequestBody LoaitourEntity tutorial) {
		LoaitourEntity entity = loaiTourRepository.findById(id);
		entity.setMaloaitour(tutorial.getMaloaitour());
		entity.setTenloaitour(tutorial.getTenloaitour());
		entity.setTrangthai(tutorial.getTrangthai());
		return new ResponseEntity<>(loaiTourRepository.save(entity), HttpStatus.OK);

	}

	@DeleteMapping("/loaitour/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			loaiTourRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@SuppressWarnings("unused")
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			storageService.save(file);
			DatabaseFile fileName = fileStorageService.storeFile(file);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
					.path(fileName.getFileName()).toUriString();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@GetMapping("/files")
	public ResponseEntity<List<FileInfo>> getListFiles() {
		List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
			String filename = path.getFileName().toString();
			String url = MvcUriComponentsBuilder
					.fromMethodName(LoaiTourController.class, "getFile", path.getFileName().toString()).build()
					.toString();

			return new FileInfo(filename, url);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.load(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	private Header createHeader(String requestType) {
		Header header = new Header();
		header.setRequest_type(requestType);
		header.setRequest_id(generateRequestId());
		header.setHref("/api/auth/loaitour");
		header.setTimestamp(generateTimestamp());
		return header;
	}

	private Result createSuccessResult(Integer count) {
		Result result = new Result();
		result.setCode("00");
		result.setMessage("success");
		result.setDescription("All the tour data");
		return result;
	}

	private Result createErrorResult(Integer count) {
		Result result = new Result();
		result.setCode("00");
		result.setMessage("success");
		result.setDescription("No tour types found");
		return result;
	}

	private String generateRequestId() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		return now.format(formatter);
	}

	private String generateTimestamp() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
		return now.format(formatter);
	}

}
