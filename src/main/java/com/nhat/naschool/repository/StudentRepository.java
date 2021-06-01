package com.nhat.naschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nhat.naschool.entity.StudentEntity;

@Repository

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
//	@Query(value = "SELECT * FROM students e INNER JOIN teachers t ON e.id_gv=t.id", nativeQuery = true)
	 StudentEntity findByAddress(String address);
//	
//	@Query(value = "SELECT * FROM studens WHERE name LIKE '%name%'",nativeQuery = true)
	 List<StudentEntity> findByName(String name);
	 StudentEntity findById(int id);
	
}
