package com.nhat.naschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nhat.naschool.entity.SubjectsEntity;

@Repository
public interface SubjectsRepo extends JpaRepository<SubjectsEntity, Integer> {
//	 @Query(value = "SELECT * FROM  subjects WHERE name LIKE '%name%'", nativeQuery = true)
	 List<SubjectsEntity> findByName(@Param("name") String name);
	 SubjectsEntity findById(int id);
	 @Query(value = "SELECT s.name FROM students s INNER JOIN subjects t ON s.id_s = t.id WHERE t.id= :id", nativeQuery = true)
	 SubjectsEntity findName (@Param("id") int id);
}
