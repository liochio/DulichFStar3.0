package com.dichvudulich.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dichvudulich.models.Dattour;

public interface DattourRepository extends JpaRepository<Dattour, Long> {

	Dattour findById(long id);

	List<Dattour> findAll();
}
