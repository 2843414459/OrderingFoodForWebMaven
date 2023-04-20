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
 * OerDingFoodForWeb
 * 2023/4/10 9:05
 * 星期一
 */
@WebServlet(urlPatterns = "/businessHome.do")
public class BusinessHomeController extends HttpServlet {

    private BusinessInfoService service = new BusinessInfoServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用业务类，完成跳转home页码逻辑
        String url = service.goHome(req);
        req.getRequestDispatcher(url).forward(req,resp);
    }
}
