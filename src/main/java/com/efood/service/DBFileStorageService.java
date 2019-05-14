package com.efood.service;

import org.springframework.web.multipart.MultipartFile;

import com.efood.dto.MultiFileResponseDTO;
import com.efood.model.DBFile;
import com.efood.model.Meal;

public interface DBFileStorageService {
//	ResponseDTO<DBFile> storeFile(MultipartFile file) throws IOException;
	MultiFileResponseDTO<DBFile, Meal> storeFiles(MultipartFile file, Meal meal);
}
