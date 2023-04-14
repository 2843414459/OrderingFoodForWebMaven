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
 * 2023/4/13 9:57
 * 星期四
 */
@WebServlet(urlPatterns = "/orderComplete.do")
public class BusOrderCompleteController extends HttpServlet {
    BusinessInfoService service = new BusinessInfoServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type","text/html; charset = UTF-8");
        String url = service.goOrderCompleter(req,"=1");
        req.setAttribute("status","2");
        req.getRequestDispatcher(url).forward(req,resp);
    }
}
