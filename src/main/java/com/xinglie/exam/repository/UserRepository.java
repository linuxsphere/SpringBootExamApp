package com.xinglie.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.xinglie.exam.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {

	  @Query("select u from #{#entityName} u where u.emailAddress = ?1")
	  List<User> findByEmail(String email);
	  
	  @Query("select u from User u where u.id = :id and u.version = :version")
	  User findByIdSortByVersion(@Param("id") Long id, @Param("version") Integer version);
	  
	  @Query("select u from User u where u.id = :id order by u.version")
	  List<User> findAllUsers(@Param("id") Long id);
	}