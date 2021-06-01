package com.nhat.naschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhat.naschool.entity.YearsEntity;

@Repository
public interface YearsRepo extends JpaRepository<YearsEntity, Integer> {

}
