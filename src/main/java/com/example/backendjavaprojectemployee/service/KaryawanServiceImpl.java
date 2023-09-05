package com.example.backendjavaprojectemployee.service;

import com.example.backendjavaprojectemployee.entity.Karyawan;
import com.example.backendjavaprojectemployee.exception.KaryawanException;
import com.example.backendjavaprojectemployee.repository.KaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KaryawanServiceImpl implements KaryawanService {

    @Autowired
    private KaryawanRepository karyawanRepository;

    @Override
    public Karyawan addKaryawan(Karyawan karyawan) {
    karyawan.setIdkaryawan(UUIDGenerator.generate());

        return karyawanRepository.save(karyawan);
    }

    @Override
    public List<Karyawan> showAllKaryawan() {
        return karyawanRepository.findAll();
    }

    @Override
    public Karyawan fetchKaryawanById(Long id) throws KaryawanException {
        Optional<Karyawan> karyawan = karyawanRepository.findById(id);

        if(!karyawan.isPresent()){
            throw new KaryawanException("Karyawan tidak ditemukan");
        }
        return karyawan.get();
    }

    @Override
    public void deleteKaryawanById(Long id) throws KaryawanException {
        boolean exist = karyawanRepository.existsById(id);
        if(!exist){
            throw new KaryawanException("karyawan dengan Id" + id + "tidak ada");
        }
        karyawanRepository.deleteById(id);

//        Karyawan departmentDB = karyawanRepository.findById(id).orElse(null);
//        if (departmentDB != null) {
//            karyawanRepository.deleteById(id);
//        } else {
//            throw new KaryawanException("Karyawan with ID " + id + " does not exist");
//        }

    }

    @Override
    public Karyawan updateKaryawan(Long id, Karyawan karyawan) throws KaryawanException {
        Karyawan updatedKaryawan = karyawanRepository.findById(id)
                .orElseThrow(() -> new KaryawanException("karyawan dengan Id" + id + "tidak ada"));


        updatedKaryawan.setNama(karyawan.getNama());
        updatedKaryawan.setEmail(karyawan.getEmail());
        updatedKaryawan.setJabatan(karyawan.getJabatan());
        updatedKaryawan.setPhone(karyawan.getPhone());
        updatedKaryawan.setImageurl(karyawan.getImageurl());
        updatedKaryawan.setTgl_lahir(karyawan.getTgl_lahir());
        karyawanRepository.save(updatedKaryawan);

        return updatedKaryawan;


    }

}
