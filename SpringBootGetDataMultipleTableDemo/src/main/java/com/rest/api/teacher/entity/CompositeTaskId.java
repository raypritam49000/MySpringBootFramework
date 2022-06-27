package com.rest.api.teacher.entity;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompositeTaskId implements Serializable {

	private static final long serialVersionUID = 1L;

	private int teacherId;
	private int taskId;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CompositeTaskId taskId1 = (CompositeTaskId) o;
		if (teacherId != taskId1.teacherId)
			return false;
		return taskId == taskId1.taskId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(teacherId, taskId);
	}
}
