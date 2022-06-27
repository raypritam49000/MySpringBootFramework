package com.rest.api.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.api.controller.BaseId;

@Repository
public interface BaseRepository extends JpaRepository<BaseId, Integer>{

}
