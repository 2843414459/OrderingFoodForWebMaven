package com.hzlx.controller;

import com.hzlx.service.BusinessInfoService;
import com.hzlx.service.impl.BusinessInfoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OerDingFoodForWeb
 * 2023/4/5 13:52
 * 星期三
 */
@WebServlet(urlPatterns = "/busRegister.do")
public class BusRegisterController extends HttpServlet {
    private BusinessInfoService businessInfoService = new BusinessInfoServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String register = businessInfoService.register(req, resp);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(register);
        requestDispatcher.forward(req,resp);
    }
}
