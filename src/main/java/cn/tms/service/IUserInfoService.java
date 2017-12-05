package cn.tms.service;

import cn.tms.entity.Privilege;
import cn.tms.entity.UserInfo;

import java.util.List;

public interface IUserInfoService {
    //1.登录方法
    public UserInfo isLogin(UserInfo info);
    //2.写一个根据用户编号获取该用户拥有所有权限的方法
    public List<Privilege> findAllPrivilegesByUserId(int userid);
}