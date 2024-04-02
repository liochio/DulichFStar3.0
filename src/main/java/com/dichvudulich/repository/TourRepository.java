package com.dichvudulich.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dichvudulich.models.TourEntity;

public interface TourRepository extends JpaRepository<TourEntity, Long> {

	TourEntity findById(long id);

	List<TourEntity> findAll();
}
