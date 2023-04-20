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
 * 2023/4/18 15:29
 * 星期二
 */
@WebServlet(urlPatterns = "/onOffsetting.do")
public class BusOnOffsettingController extends HttpServlet {
    BusinessInfoService service = new BusinessInfoServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = service.onOffsetting(req);
        resp.getWriter().write(url);

    }
}
