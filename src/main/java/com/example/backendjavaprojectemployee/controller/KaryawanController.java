package com.example.backendjavaprojectemployee.controller;

import com.example.backendjavaprojectemployee.entity.Karyawan;
import com.example.backendjavaprojectemployee.exception.KaryawanException;
import com.example.backendjavaprojectemployee.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/karyawan")
public class KaryawanController {
    @Autowired
    private KaryawanService karyawanService;
    @PostMapping("/add")
    public Karyawan addKaryawan(@RequestBody Karyawan karyawan){
        return karyawanService.addKaryawan(karyawan);
    }

    @GetMapping("/all")
    public List<Karyawan> showAllKaryawan(){
        return karyawanService.showAllKaryawan();
    }

    @GetMapping("/cari/{id}")
    public Karyawan fetchKaryawanById(@PathVariable("id") Long id) throws KaryawanException {
        return karyawanService.fetchKaryawanById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteKaryawanById(@PathVariable("id") Long id) throws KaryawanException {
        karyawanService.deleteKaryawanById(id);
        return "Data has been deleted succesfully!!";
    }

    @PutMapping("/update/{id}")
    public Karyawan updateKaryawan(@PathVariable("id") Long id,
                                       @RequestBody Karyawan karyawan) throws KaryawanException {
        return karyawanService.updateKaryawan(id,karyawan);
    }
}
