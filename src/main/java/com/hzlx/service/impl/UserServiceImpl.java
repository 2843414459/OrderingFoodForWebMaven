package com.hzlx.service.impl;

import com.hzlx.dao.UserInfoDao;
import com.hzlx.dao.impl.UserInfoDaoImpl;
import com.hzlx.entity.UserInfo;
import com.hzlx.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class UserServiceImpl implements UserService {
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();
    @Override
    public String login(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        UserInfo userInfo = userInfoDao.selectUserInfoByUserNameAndPwd(userName, password);
        String contextPath = request.getContextPath();
        if (userInfo!=null){
            request.getSession().setAttribute("userInfo",userInfo);
            return contextPath+"/userHome.do";
        }else {
            return contextPath+"/pages/user/login.jsp";
        }
    }
}
