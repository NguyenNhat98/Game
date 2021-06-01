package com.nhat.naschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nhat.naschool.entity.ClassEntity;



@Repository
public interface ClassRepo extends JpaRepository<ClassEntity, Integer> {

//	@Query(value = "SELECT * FROM class WHERE name LIKE '%name%'" , nativeQuery = true)
	  List<ClassEntity> findByName(@Param("name") String name);
	  ClassEntity findById(int id);
	  
	  @Query(value = "SELECT s.name FROM students s INNER JOIN class t ON s.id_class = t.id WHERE t.id= :id", nativeQuery = true)
	  ClassEntity findName (@Param("id") int id);
}
