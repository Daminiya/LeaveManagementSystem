package com.sgic.hrm.leavesystem.DTOMapping;

import com.sgic.hrm.leavesystem.entity.Login;
import com.sgic.hrm.leavesystem.entity.User;
import com.sgic.hrm.leavesystem.model.UserModel;

public class UserDtoMapping {

  public UserModel userToDtoMapping(User user, Login login) {

    // Login userLogin = loginService.getLoginByUserName(user.getUserName());

    UserModel userModel = new UserModel();


    userModel.setId(user.getId());
    userModel.setFirstName(user.getFirstName());
    userModel.setLastName(user.getLastName());
    userModel.setEmail(user.getEmail());
    userModel.setUserName(user.getUserName());
    userModel.setServicePeriod(user.getServicePeriod());
    userModel.setJoinDate(user.getJoinDate());
    userModel.setPassword(login.getPassword());
    userModel.setRoleId(user.getRoleId().getId());
    userModel.setDepartmentId(user.getDepartmentId().getId());

    return userModel;


  }
}
