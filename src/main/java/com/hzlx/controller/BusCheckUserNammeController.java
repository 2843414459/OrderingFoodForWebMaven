package com.hzlx.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OerDingFoodForWeb
 * 2023/4/7 9:34
 * 星期五
 */
@WebServlet(urlPatterns = "/busCheckUserName.do")
public class BusCheckUserNammeController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
