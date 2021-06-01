package com.nhat.naschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhat.naschool.entity.Gv_sv;
import com.nhat.naschool.repository.Gv_svRepo;


@Service
public class Gv_svService {

    @Autowired
    Gv_svRepo gv_svRepo;

    public List<Gv_sv> getAllSV(){
        return gv_svRepo.findAll();
    }

    public List<Gv_sv> findByidGv(int id_gv){
        return gv_svRepo.findById(id_gv);
    }
    
	
}
