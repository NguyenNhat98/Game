package com.nhat.naschool.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nhat.naschool.entity.SubjectsEntity;
import com.nhat.naschool.repository.SubjectsRepo;


@Service
public class SubjectsService {

	
	@Autowired
    private SubjectsRepo subjectsRepo;

    public List<SubjectsEntity> findAll(){
        return subjectsRepo.findAll();
    }



    public void save(SubjectsEntity subjects){
    	subjectsRepo.save(subjects);
    }

    public void delete(int id){
    	subjectsRepo.deleteById(id);
    }
    public SubjectsEntity update(SubjectsEntity subjects){
        return subjectsRepo.save(subjects);
    }

    public List<SubjectsEntity> findByName(String name){
        return subjectsRepo.findByName(name);
    }
    public SubjectsEntity findById(int id){
        return subjectsRepo.findById(id);
    }
    
    
    public SubjectsEntity findName(int id) {
    	return subjectsRepo.findName(id);
    }
}
