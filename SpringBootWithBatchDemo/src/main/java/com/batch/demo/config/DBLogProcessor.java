package com.batch.demo.config;

import org.springframework.batch.item.ItemProcessor;

import com.batch.demo.model.Hotels;

public class DBLogProcessor implements ItemProcessor<Hotels, Hotels> {
	public Hotels process(Hotels Hotel) throws Exception {
		System.out.println("Inserting Hotels : " + Hotel);
		return Hotel;
	}
}