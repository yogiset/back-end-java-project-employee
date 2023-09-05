package com.example.backendjavaprojectemployee.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "karyawan")
public class Karyawan implements Serializable {
    @Id
    @SequenceGenerator(name = "karyawan_sequence",sequenceName = "karyawan_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "karyawan_sequence")
    private Long id;
    private String nama;
    private String email;
    private String jabatan;
    private String phone;
    private String imageurl;
    private LocalDate tgl_lahir;
    @Transient
    private Integer umur;
    private String idkaryawan;

    public Integer getUmur() {
        return Period.between(this.tgl_lahir,LocalDate.now()).getYears();

    }


}

