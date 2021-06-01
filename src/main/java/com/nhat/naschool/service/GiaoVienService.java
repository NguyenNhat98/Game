package com.nhat.naschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhat.naschool.entity.GiaoVien;
import com.nhat.naschool.repository.GiaoVienRepository;



@Service
public class GiaoVienService {

    @Autowired
    private GiaoVienRepository gvRepository;

    public List<GiaoVien> listAllGiaoVien(){
        return gvRepository.findAll();
    }

    public GiaoVien getGiaoVien(int id){
        return gvRepository.findById(id);
    }

    public void saveGiaoVien(GiaoVien gv){
        gvRepository.save(gv);
    }

    public void deleteGV(int id){
        gvRepository.deleteById(id);
    }
    public GiaoVien updateGV(GiaoVien giaoVien){
        return gvRepository.save(giaoVien);
    }

    public List<GiaoVien> findByName(String name){
        return gvRepository.findByName(name);
    }
    public GiaoVien findById(int id){
        return gvRepository.findById(id);
    }
    
    public GiaoVien findName(int id) {
    	return gvRepository.findName(id);
    }

//    public Page<GiaoVien> findPageable(Pageable pageable){
//        int pagesize= pageable.getPageSize();
//        int current= pageable.getPageNumber();
//        int startItem= current+ pagesize;
//        List<GiaoVien> list;
//
////        Page<GiaoVien> giaoVienPage= new PageImpl<GiaoVien>()
//
//    }
}

