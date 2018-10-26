package com.sgic.hrm.leavesystem.model;

public class LoggedUserModel {

  private Integer userId;
  private String userName;
  private String userRole;
  private String userDepartment;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }

  public String getUserDepartment() {
    return userDepartment;
  }

  public void setUserDepartment(String userDepartment) {
    this.userDepartment = userDepartment;
  }

}
