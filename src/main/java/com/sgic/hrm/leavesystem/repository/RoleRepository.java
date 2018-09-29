package com.sgic.hrm.leavesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.sgic.hrm.leavesystem.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>, QuerydslPredicateExecutor<Role>{

}
