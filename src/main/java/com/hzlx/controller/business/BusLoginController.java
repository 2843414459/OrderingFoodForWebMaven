package com.hzlx.controller.business;

import com.hzlx.service.BusinessInfoService;
import com.hzlx.service.impl.BusinessInfoServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OerDingFoodForWeb
 * 2023/4/5 10:45
 * 星期三
 * @author 商家登录接口
 */
@WebServlet(urlPatterns = "/busLogin.do")
public class BusLoginController extends HttpServlet{
    private BusinessInfoService businessInfoService;

    @Override
    public void init() throws ServletException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        businessInfoService = applicationContext.getBean("businessInfoService", BusinessInfoServiceImpl.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*req.setCharacterEncoding("UTF-8");
        //获取请求中的数据
        String userName=req.getParameter("userName");
        String pwd = req.getParameter("pwd");

        //调用service中的登录方法
        BusinessInfo businessInfo = businessInfoService.login(userName, pwd);




        RequestDispatcher requestDispatcher;

        if (null!=businessInfo){
            //登录成功妆发到home.jsp
            requestDispatcher = req.getRequestDispatcher("/pages/business/home.jsp");
        }else {
            //登录失败？转发到login.jsp
            requestDispatcher = req.getRequestDispatcher("/pages/business/login.jsp");
        }
        requestDispatcher.forward(req,resp);*/
        /**调用service层的login方法，返回转发的url
         *
         */
        String url = businessInfoService.login(req, resp);
        resp.getWriter().write(url);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
        requestDispatcher.forward(req,resp);
    }
}
