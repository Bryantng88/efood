package com.efood.service;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.efood.common.MessageConst;
import com.efood.dto.ResponseDTO;
import com.efood.exception.FileStorageException;
import com.efood.exception.MyFileNotFoundException;

@Service
public class FileStorageService {
	private static final Logger logger = LogManager.getLogger();

	public ResponseDTO<Boolean> storeFile(MultipartFile file) {
		ResponseDTO<Boolean> response = new ResponseDTO<Boolean>();
		response.setData(false);
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Path path = Paths.get(MessageConst.UPLOAD_FOLDER + file.getOriginalFilename());
		if (fileName.contains("..")) {
			response.setErrorMessage(MessageConst.ERROR_FILE_NAME_INVALID + fileName);
		}
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(fileName)
	                .toUriString();
			response.setData(true);

		} catch (Exception e) {
			e.printStackTrace();
			response.setErrorMessage(MessageConst.ERROR_FILE_NOT_STORED);
		}
		return response;
	}

	public Resource getFile(String fileName) {
		try {
			Path path = Paths.get(MessageConst.UPLOAD_FOLDER).resolve(fileName);
			Resource resource = new UrlResource(path.toUri());
			if (resource.exists()) {
				logger.info("my resource: " + resource);
				return resource;
			} else {
				throw new MyFileNotFoundException("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new MyFileNotFoundException("File not found" + fileName);
		}
		
	}

}
