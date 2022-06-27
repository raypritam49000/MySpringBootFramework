package com.rest.api.user.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.api.user.entity.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {

	@Query("FROM UserData where userId= :id")
	public List<UserData> findBySearchTerm(@Param("id") Long id);

	@Query("SELECT ua.city FROM UserAddress ua WHERE ua.userdata.userId = ?1")
	public String findCityByUserId(Long userId);

}