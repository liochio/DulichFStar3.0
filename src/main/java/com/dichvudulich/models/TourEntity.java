package com.dichvudulich.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "tour")
public class TourEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 255)
    private String mota;
    @Size(max = 255)
    private String motachitiet;
    @Size(max = 100)
    private String hinhanh;
    private Integer gia;
    @Size(max = 100)
    private String diadiem;
    private Date thoigiankhoihanh;
    private Integer soluongkhach;
    private Boolean trangthai;
    private Long tour_id;

//	@ManyToOne
//	@JoinColumn(name = "id_loaitour")
//	private LoaitourEntity loaitour;

    public Long getTour_id() {
        return tour_id;
    }

    public void setTour_id(Long tour_id) {
        this.tour_id = tour_id;
    }

    public TourEntity() {
        super();
    }

    public TourEntity(@Size(max = 255) String mota, @Size(max = 255) String motachitiet,
                      @Size(max = 100) String hinhanh, Integer gia, @Size(max = 100) String diadiem, Date thoigiankhoihanh,
                      Integer soluongkhach, Boolean trangthai) {
        super();
        this.mota = mota;
        this.motachitiet = motachitiet;
        this.hinhanh = hinhanh;
        this.gia = gia;
        this.diadiem = diadiem;
        this.thoigiankhoihanh = thoigiankhoihanh;
        this.soluongkhach = soluongkhach;
        this.trangthai = trangthai;
    }
}
