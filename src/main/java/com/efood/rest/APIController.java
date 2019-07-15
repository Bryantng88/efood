package com.efood.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class APIController {
	protected static final Logger logger = LogManager.getLogger();
	protected static final Gson gson = new GsonBuilder().create();
}
