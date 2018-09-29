package com.sgic.hrm.leavesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.sgic.hrm.leavesystem.entity.Login;

public interface LoginRepository extends JpaRepository<Login,String>, QuerydslPredicateExecutor<Login> {

	@Query("SELECT lg FROM login as lg WHERE lg.userName=?1 AND lg.password=?2")
	List<Login> findByUserNameAndPassword(String userName, String password);
}
