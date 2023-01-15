package com.database.join.api.models;

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

}