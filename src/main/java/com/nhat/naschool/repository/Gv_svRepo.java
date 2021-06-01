package com.nhat.naschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhat.naschool.entity.Gv_sv;

@Repository
public interface Gv_svRepo extends JpaRepository<Gv_sv, Integer> {
//	@Query(value = "select * from gv_sv where id_gv =:id_gv",nativeQuery = true)
    public List<Gv_sv> findById(int id_gv);
}
