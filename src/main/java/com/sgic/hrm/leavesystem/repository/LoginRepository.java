package com.sgic.hrm.leavesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgic.hrm.leavesystem.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{
	
	@Query("SELECT lg FROM Login as lg WHERE lg.user.userName=?1 AND lg.password=?2")
	List<Login> findByUserNameAndPassword(String userName, String password);
	
	@Query("SELECT lg FROM Login as lg WHERE lg.user.userName=?1")
	Login findByUserName(String userName);
}
