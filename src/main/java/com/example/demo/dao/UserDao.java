//Repository for ABCCommunity
//Data Access Object

package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.User;
import java.lang.String;

@Repository
public interface UserDao extends JpaRepository <User, Integer> {
	List<User> findByUsernameContaining(String search);

	User findByEmail(String email);
	
	@Query(value = "SELECT COUNT(email) FROM abc WHERE email = ?1", nativeQuery = true)
	String register(String email);
	
}
