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
 * 2023/4/12 17:07
 * 星期三
 * @author
 */
@WebServlet(urlPatterns = "/order.do")
public class BusOrderController extends HttpServlet {
    private BusinessInfoService service = new BusinessInfoServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = service.goOrder(req);
        req.setAttribute("status","0");
        req.getRequestDispatcher(url).forward(req,resp);
    }
}
