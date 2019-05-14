package com.efood.repository;

import com.efood.model.DBFile;
import com.efood.model.Meal;

public interface DBFileRepository {
	DBFile save(DBFile dbFile);
	void addMeal(DBFile file, Meal meal);
}
