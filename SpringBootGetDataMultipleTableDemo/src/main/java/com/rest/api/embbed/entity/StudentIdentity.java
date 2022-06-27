package com.rest.api.embbed.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentIdentity implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(max = 20)
	private int studentId;

	@NotNull
	@Size(max = 20)
	private int companyId;

}