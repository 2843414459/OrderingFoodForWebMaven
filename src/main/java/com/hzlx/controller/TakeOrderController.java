package com.hzlx.controller;

import com.hzlx.service.impl.OrderInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OerDingFoodForWeb
 * 2023/4/10 11:29
 * 星期一
 * @author 接单的Controller
 */
@WebServlet(urlPatterns = "/takeOrder.do")
public class TakeOrderController extends HttpServlet {
    private OrderInfoServiceImpl orderInfoService = new OrderInfoServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type","text/html; charset = UTF-8");
        resp.getWriter().write(orderInfoService.takeOrder(req));

//        req.getRequestDispatcher(orderInfoService.takeOrder(req)).forward(req,resp);
    }
}
