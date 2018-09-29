package com.sgic.hrm.leavesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.hrm.leavesystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
