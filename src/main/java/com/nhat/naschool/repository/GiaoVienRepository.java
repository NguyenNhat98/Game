package com.nhat.naschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nhat.naschool.entity.GiaoVien;
@Repository
 public interface GiaoVienRepository extends JpaRepository<GiaoVien, Integer> {

	 GiaoVien findByAddress(String address);
	 
//	 @Query(value = "SELECT * FROM  subjects WHERE name LIKE '%name%'", nativeQuery = true)
	   List<GiaoVien> findByName(String name);
	    GiaoVien findById(int id);
	    @Query(value = "SELECT s.name FROM students s INNER JOIN teachers t ON s.id_gv = t.id WHERE t.id= :id", nativeQuery = true)
		 GiaoVien findName (@Param("id") int id);
//	    @Query("select e from teachers e")
//
//	    Page<GiaoVien> findGiaoVien(Pageable pageable);
	 
}
