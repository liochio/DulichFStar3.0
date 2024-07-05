package com.dichvudulich.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dichvudulich.models.LoaitourEntity;
import com.dichvudulich.models.Order;

public interface LoaiTourRepository extends JpaRepository<LoaitourEntity, Long> {

	LoaitourEntity findById(long id);

	@Query(value = "SELECT * FROM fstardb.loaitour  WHERE trangthai = 1", nativeQuery = true)
	Page<LoaitourEntity> findAllByTrangThai(Pageable pageable);

	@Query(value = "SELECT * FROM fstardb.loaitour  WHERE maloaitour = 'TN'", nativeQuery = true)
	List<LoaitourEntity> findByStatus();

	@Query(value = "SELECT * FROM orders  JOIN products ON (orders.id = products.product_id)", nativeQuery = true)
	List<Order> findAllTour();

}
