package com.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.api.entity.BaseId;

@Repository
public interface BaseRepository extends JpaRepository<BaseId, Integer> {

}
