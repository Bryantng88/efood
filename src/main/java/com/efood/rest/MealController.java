package com.efood.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.efood.dto.MealDTO;
import com.efood.dto.MealRequestDTO;
import com.efood.dto.ResponseDTO;
import com.efood.model.Meal;
import com.efood.service.FileStorageService;
import com.efood.service.MealService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MealController extends APIController {

	@Autowired
	private FileStorageService fileStorageService;

	@Autowired
	MealService mealService;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(method = RequestMethod.POST, value = "no-auth/meal", consumes = { "multipart/form-data" })
	public ResponseEntity<ResponseDTO<Boolean>> addMeal(@RequestParam("file") MultipartFile file,
			@RequestParam("meal") String dataRequest) {
		ResponseDTO<Boolean> response = new ResponseDTO<Boolean>();
		response.setData(true);
		fileStorageService.storeFile(file);	
		
		System.out.println(dataRequest);
		
		if (dataRequest.length() > 0) {
			MealRequestDTO request = gson.fromJson(dataRequest, MealRequestDTO.class);
			Meal meal = request.toMeal();
			meal.setFilePath(file.getOriginalFilename());
			ResponseDTO<Meal> result = mealService.save(meal);
			if (result.getData() == null) {
				response.setData(false);
				response.setErrorMessage(result.getErrorMessage());
			}
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(method = RequestMethod.GET, value = "no-auth/load-meal")
	public ResponseEntity<ResponseDTO<List<MealDTO>>> findMeal() {
		ResponseDTO<List<MealDTO>> response = new ResponseDTO<List<MealDTO>>();
		List<Meal> meals = mealService.findAll();
		if (meals != null) {
			List<MealDTO> mealsDto = new ArrayList<MealDTO>();
			for (Meal item : meals) {
				MealDTO mealDTO = new MealDTO();
				mealDTO.copyFrom(item);
				mealsDto.add(mealDTO);
			}
			response.setData(mealsDto);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
