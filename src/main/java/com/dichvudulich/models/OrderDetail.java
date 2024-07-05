package com.dichvudulich.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
//     
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;
// 
    // constructors, getters and setters are not shown 
}