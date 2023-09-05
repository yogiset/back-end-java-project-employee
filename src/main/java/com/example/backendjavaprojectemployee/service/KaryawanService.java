package com.example.backendjavaprojectemployee.service;

import com.example.backendjavaprojectemployee.entity.Karyawan;
import com.example.backendjavaprojectemployee.exception.KaryawanException;

import java.util.List;

public interface KaryawanService {
    Karyawan addKaryawan(Karyawan karyawan);

    List<Karyawan> showAllKaryawan();

    Karyawan fetchKaryawanById(Long id) throws KaryawanException;

    void deleteKaryawanById(Long id) throws KaryawanException;

    Karyawan updateKaryawan(Long id, Karyawan karyawan) throws KaryawanException;
}
