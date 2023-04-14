package com.hzlx.controller;

import com.hzlx.service.BusinessInfoService;
import com.hzlx.service.impl.BusinessInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OrderingFoodForWebMaven
 * 2023/4/13 14:55
 * 星期四
 */
@WebServlet(urlPatterns = "/setting.do")
public class BusSettingController extends HttpServlet {
    BusinessInfoService service = new BusinessInfoServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = service.goSetting(req);
        req.getRequestDispatcher(url).forward(req,resp);
    }
}
