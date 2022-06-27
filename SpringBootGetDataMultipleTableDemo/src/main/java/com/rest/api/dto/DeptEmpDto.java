package com.rest.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptEmpDto {

	private String empDept;
	private String empName;
	private String empEmail;
	private String empAddress;
	
	public DeptEmpDto(String empName, String empEmail, String empAddress) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.empAddress = empAddress;
	}
	
	
	
}
