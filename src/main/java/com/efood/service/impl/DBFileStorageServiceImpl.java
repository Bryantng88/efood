package com.efood.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.efood.dto.MultiFileResponseDTO;
import com.efood.dto.ResponseDTO;
import com.efood.exception.FileStorageException;
import com.efood.model.DBFile;
import com.efood.model.Meal;
import com.efood.repository.DBFileRepository;
import com.efood.service.DBFileStorageService;

@Service
public class DBFileStorageServiceImpl implements DBFileStorageService {

	private static final Logger logger = LogManager.getLogger();

	@Autowired
	private DBFileRepository dbFileRepository;

	private static String UPLOAD_FOLDER = "/files";

//	public ResponseDTO<DBFile> storeFile(MultipartFile file) {
//
//		ResponseDTO<DBFile> response = new ResponseDTO<DBFile>();
//		// Normalize file name
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		// Check if the file's name contains invalid characters
//		if (fileName.contains("..")) {
//			throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
//		}
//
//		DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getSize());
//		dbFileRepository.save(dbFile);
//		response.setData(dbFile);
//		return response;
//
//	}

	@Override
	public MultiFileResponseDTO<DBFile, Meal> storeFiles(MultipartFile file, Meal meal) {
		MultiFileResponseDTO<DBFile, Meal> response = new MultiFileResponseDTO<DBFile, Meal>();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			logger.debug("this is debug at file storage service: " + fileName);
			
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

			logger.info("this is only for information: " + path);

			DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getSize());

			dbFileRepository.addMeal(dbFile, meal);
			response.setFileData(dbFile);
			response.setJsonData(meal);
			System.out.println(response.getJsonData());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

}
