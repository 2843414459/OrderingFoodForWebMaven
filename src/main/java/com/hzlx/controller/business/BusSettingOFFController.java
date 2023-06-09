package com.hzlx.controller.business;

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
 * 2023/4/18 14:00
 * 星期二
 */
@WebServlet (urlPatterns = "/offSetting.do")
public class BusSettingOFFController extends HttpServlet {
    BusinessInfoService service = new BusinessInfoServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("status",1);
        String url = service.OffSetting(req);
        req.getRequestDispatcher(url).forward(req,resp);
    }
}
