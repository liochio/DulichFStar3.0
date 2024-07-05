package com.dichvudulich.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "sport")
public class Sport247 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maSport;
    private String tenSport;
    private String tieuDeSport;
    private String moTa;
    private String moTaChiTiet;
    private String hinhAnh;
    private Boolean trangThai;
}
