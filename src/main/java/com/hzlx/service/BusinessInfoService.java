package com.hzlx.service;

import com.hzlx.entity.BusinessInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * OerDingFoodForWeb
 * 2023/4/5 10:51
 * 星期三
 */
public interface BusinessInfoService {

    String login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException;

    BusinessInfo login(String userName, String pwd);

    String register(HttpServletRequest request, HttpServletResponse response) throws IOException;

    Integer checkUserName(HttpServletRequest request, HttpServletResponse response)throws UnsupportedEncodingException ;

    String goHome(HttpServletRequest req);

    String goOrder(HttpServletRequest req);

    String goOrderPro(HttpServletRequest req);

    String goOrderCompleter(HttpServletRequest req,String status);

    String goSetting(HttpServletRequest req);

    String OffSetting(HttpServletRequest req);

    String onOffsetting(HttpServletRequest req);

    void settingPublic(HttpServletRequest req);

    String AddSrtting(HttpServletRequest req);
}
