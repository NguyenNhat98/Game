package com.nhat.naschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nhat.naschool.entity.User;



@Repository
public interface UserRepo extends JpaRepository<User, Long>{
//	User save(UserRegistrationDto registrationDto);
//	User findByName(String name);
////	@Query(value = "select u from user u WHERE" + " (u.email = :email OR :email IS NULL)",nativeQuery = false)
	User findByEmail( String email);
	
}
