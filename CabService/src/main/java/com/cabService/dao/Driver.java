package com.cabService.dao;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String mobno;

    @Column(unique = true, nullable = false)
    private String emailid;

    @Column(unique = true, nullable = false)
    private String licenseNo;

    private Double rating;

    @OneToOne
    private Cabs cab;
}