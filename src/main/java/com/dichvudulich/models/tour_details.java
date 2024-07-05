package com.dichvudulich.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tour_details")
public class tour_details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@ManyToOne
//	@JoinColumn(name = "tour_id")
//	private TourEntity tourEntity;
//
//	@ManyToOne
//	@JoinColumn(name = "loaitour_id")
//	private LoaitourEntity loaiTourEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



}
