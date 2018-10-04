package com.sgic.hrm.leavesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.hrm.leavesystem.entity.User;
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String userName);
}
