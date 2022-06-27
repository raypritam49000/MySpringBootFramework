package com.rest.api.teacher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.api.teacher.entity.CompositeTaskId;
import com.rest.api.teacher.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, CompositeTaskId> {

    @Query(value = "FROM Teacher")
    public abstract List<Teacher> getAllTeachers();
    
    @Query(value="SELECT t.teacherId,t.taskId,t.name,t.city,t.email FROM Teacher t")
    public abstract List<Object[]> getAllTechersData();
}
