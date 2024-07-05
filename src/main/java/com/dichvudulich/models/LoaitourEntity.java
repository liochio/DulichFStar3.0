package com.dichvudulich.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "loaitour")
public class LoaitourEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max = 10)
	private String maloaitour;
	@Size(max = 50)
	private String tenloaitour;
	private Boolean trangthai;

//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "tour_detail", joinColumns = @JoinColumn(name = "loaitour_id"), inverseJoinColumns = @JoinColumn(name = "tour_id"))
//	private Set<TourEntity> tour = new HashSet<>();
	
	
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "tour_id")
	List<TourEntity> tour;
	



	public List<TourEntity> getTour() {
		return tour;
	}

	public void setTour(List<TourEntity> tour) {
		this.tour = tour;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LoaitourEntity() {
		super();
	}

	public LoaitourEntity(@Size(max = 10) String maloaitour, @Size(max = 50) String tenloaitour, Boolean trangthai) {
		super();
		this.maloaitour = maloaitour;
		this.tenloaitour = tenloaitour;
		this.trangthai = trangthai;
	}
}
