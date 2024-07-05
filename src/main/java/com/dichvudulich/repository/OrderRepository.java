package com.dichvudulich.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dichvudulich.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	@Query(value = "SELECT distinct orders.id, orders.maloaitour,orders.tenloaitour, orders.order_id,products.diadiem, products.gia,products.trangthai  FROM orders  JOIN products ON (orders.id = products.product_id)", nativeQuery = true)
	List<Order> findAllTour();
}
