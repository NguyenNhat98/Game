package com.nhat.naschool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nhat.naschool.entity.YearsEntity;
import com.nhat.naschool.repository.YearsRepo;

@Service
public class YearsService {

	@Autowired
	YearsRepo yearsRepo;
	
	public List<YearsEntity> findAll(){
		return yearsRepo.findAll();	
	}
	
	public Optional<YearsEntity> findById(int id) {
		return yearsRepo.findById(id);		
	}
	
	public void saveYears(YearsEntity yearsEntity){
		yearsRepo.save(yearsEntity);
    }

    public void deleteYears(int id){
    	yearsRepo.deleteById(id);
    }
    public YearsEntity updateYears(YearsEntity yearsEntity){
		return yearsRepo.save(yearsEntity);
    }

   
   
}
