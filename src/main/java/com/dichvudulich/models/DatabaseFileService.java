package com.dichvudulich.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dichvudulich.repository.DatabaseFileRepository;

@Service
public class DatabaseFileService {

	private final Path root = Paths.get("uploads");

	public void init() {
		try {
			Files.createDirectories(root);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize folder for upload!");
		}
	}

	@Autowired
	private DatabaseFileRepository dbFileRepository;

	public DatabaseFile storeFile(MultipartFile file) {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			Path filePath = this.root.resolve(fileName);

			// Check if the file exists
			int counter = 1;
			String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
			String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
			while (Files.exists(filePath)) {
				fileName = baseName + " (" + counter + ")." + extension;
				filePath = this.root.resolve(fileName);
				counter++;
			}

			// Copy the new file
			Files.copy(file.getInputStream(), filePath);

			// Files.copy(file.getInputStream(),
			// this.root.resolve(file.getOriginalFilename()));

			DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());

			return dbFileRepository.save(dbFile);
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public DatabaseFile getFile(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
