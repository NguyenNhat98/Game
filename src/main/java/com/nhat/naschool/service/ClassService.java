package com.nhat.naschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nhat.naschool.entity.ClassEntity;
import com.nhat.naschool.repository.ClassRepo;


@Service
public class ClassService {

	
	@Autowired
    private ClassRepo ClassRepo;

    public List<ClassEntity> listAllClass(){
        return ClassRepo.findAll();
    }

    public ClassEntity getClass(int id){
        return ClassRepo.findById(id);
    }

    public void saveClass(ClassEntity classEntity){
    	ClassRepo.save(classEntity);
    }

    public void deleteClass(int id){
    	ClassRepo.deleteById(id);
    }
    public ClassEntity updateClass(ClassEntity classEntity){
		return ClassRepo.save(classEntity);
    }

    public List<ClassEntity> findByName(String name){
        return ClassRepo.findByName(name);
    }
    public ClassEntity findById(int id){
        return ClassRepo.findById(id);
    }
    
    public ClassEntity findName(int id) {
    	return ClassRepo.findName(id);
    }
}
