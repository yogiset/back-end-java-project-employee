package com.example.backendjavaprojectemployee.repository;

import com.example.backendjavaprojectemployee.entity.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan,Long> {
}
