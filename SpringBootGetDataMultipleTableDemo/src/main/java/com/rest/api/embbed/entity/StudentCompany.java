package com.rest.api.embbed.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCompany {
	private int studentId;
	private int companyId;
	private String name;
	private String email;
	private String mobile;
}
