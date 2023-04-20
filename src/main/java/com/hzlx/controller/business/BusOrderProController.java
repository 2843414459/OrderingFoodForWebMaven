package com.hzlx.controller.business;

import com.hzlx.service.BusinessInfoService;
import com.hzlx.service.impl.BusinessInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * OrderingFoodForWebMaven
 * 2023/4/12 18:02
 * 星期三
 */
@WebServlet(urlPatterns = "/orderPro.do")
public class BusOrderProController extends HttpServlet {

    BusinessInfoService service = new BusinessInfoServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("status","1");
        resp.setHeader("Content-Type","text/html; charset = UTF-8");
        req.getRequestDispatcher(service.goOrderPro(req)).forward(req,resp);
    }
}
