package com.dichvudulich.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dichvudulich.models.LoaitintucEntity;

public interface LoaiTintucRepository extends JpaRepository<LoaitintucEntity, Long> {

	Optional<LoaitintucEntity> findById(Long id);

	List<LoaitintucEntity> findAll();

}
