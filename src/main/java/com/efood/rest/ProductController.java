package com.efood.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.efood.dto.FileDTO;
import com.efood.dto.MealRequestDTO;
import com.efood.dto.MultiFileResponseDTO;
import com.efood.dto.ResponseDTO;
import com.efood.model.DBFile;
import com.efood.model.Meal;
import com.efood.service.DBFileStorageService;
import com.efood.service.MealService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private static final Logger logger = LogManager.getLogger();

	
	@Autowired
	private MealService mealService;

	@Autowired
	private DBFileStorageService DBFileStorageService;

//	@CrossOrigin(origins = "*", allowedHeaders = "*")
//	@RequestMapping(method = RequestMethod.POST, value = "no-auth/file/add", consumes = { "multipart/form-data" })
//	public ResponseEntity<ResponseDTO<FileDTO>> uploadFile(@RequestParam("file") MultipartFile file) {
//		ResponseDTO<FileDTO> response = new ResponseDTO<FileDTO>();
//
//		// try to store file
//		ResponseDTO<DBFile> dbFileResult = DBFileStorageService.storeFile(file);
//		
//		// copy data to DTO if store successfully
//		if (dbFileResult != null) {
//			FileDTO fileDTO = new FileDTO();
//			fileDTO.copyFrom(dbFileResult.getData());
//			response.setData(fileDTO);
//		}
//		return new ResponseEntity<ResponseDTO<FileDTO>>(response, HttpStatus.BAD_REQUEST);
//	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(method = RequestMethod.POST, value = "no-auth/files/add", consumes = { "multipart/form-data"} )
	public ResponseEntity<?> uploadFiles(@RequestParam("file") MultipartFile file, @RequestParam("meal") String mealRequest) {
		MultiFileResponseDTO<FileDTO, Meal> response = new MultiFileResponseDTO<FileDTO, Meal>();
		Gson gson = new GsonBuilder().create();
		// convert to JSON
		logger.info("this is logger: " + file);
		Meal meal = gson.fromJson(mealRequest, Meal.class);
		// try to store file		
		// viet log : dung logger
		
		
		//luu file vao folder -> luu path xuong db
		MultiFileResponseDTO<DBFile, Meal> result = DBFileStorageService.storeFiles(file, meal);
		
		// copy data to DTO if store successfully
		if (result != null) {
			FileDTO fileDTO = new FileDTO();
			fileDTO.copyFrom(result.getFileData());
			response.setFileData(fileDTO);
			response.setJsonData(meal);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

//	@RequestMapping(method = GET, value="/downloadFile")

}
