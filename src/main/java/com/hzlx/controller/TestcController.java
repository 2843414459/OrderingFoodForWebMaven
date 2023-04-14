package com.hzlx.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OrderingFoodForWebMaven
 * 2023/4/12 11:13
 * 星期三
 * @author laogeng
 */
@WebServlet(urlPatterns = "/test.do")
public class TestcController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<h1 style = 'color:red'>Hello Maven</h1>");
    }
}
