package com.nhat.naschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nhat.naschool.entity.StudentEntity;
import com.nhat.naschool.repository.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
    private StudentRepository svRepository;

    public List<StudentEntity> listAllStudent(){
        return svRepository.findAll();
    }

    public StudentEntity getStudent(int id){
        return svRepository.findById(id);
    }

    public void saveStudent(StudentEntity student){
    	svRepository.save(student);
    }

    public void deleteStudent(int id){
    	svRepository.deleteById(id);
    }
    public StudentEntity updateStudent(StudentEntity student){
        return svRepository.save(student);
    }

    public List<StudentEntity> findByName(String name){
        return svRepository.findByName(name);
    }
    public StudentEntity findById(int id){
        return svRepository.findById(id);
    }
    
    
  

//    public YearsEntity findByYear_s(Date year_s) {
//		return svRepository.findByYear_s(year_s);
//    	
//    }

}
