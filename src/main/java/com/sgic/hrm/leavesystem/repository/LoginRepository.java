package com.sgic.hrm.leavesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgic.hrm.leavesystem.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{
	
	@Query("SELECT lg FROM login as lg WHERE lg.user.userName=?1 AND lg.password=?2")
	Login findByUserNameAndPassword(String userName, String password);
}
