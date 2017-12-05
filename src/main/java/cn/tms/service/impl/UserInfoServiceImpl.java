package cn.tms.service.impl;

import cn.tms.dao.IUserInfoDao;
import cn.tms.entity.Privilege;
import cn.tms.entity.UserInfo;
import cn.tms.service.IUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {
    @Resource(name = "IUserInfoDao")
    private IUserInfoDao userInfodao;

    public UserInfo isLogin(UserInfo info) {
        return userInfodao.isLogin(info);
    }

    public List<Privilege> findAllPrivilegesByUserId(int userid) {
        return userInfodao.findAllPrivilegesByUserId(userid);
    }
}