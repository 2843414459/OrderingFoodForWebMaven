package com.hzlx.service.impl;

import com.google.gson.Gson;
import com.hzlx.dao.BusinessInfoDao;
import com.hzlx.dao.FoodInfoDao;
import com.hzlx.dao.OrderInfoDao;
import com.hzlx.dao.impl.BusinessInfoDaoImpl;
import com.hzlx.dao.impl.FoodInfoDaoImpl;
import com.hzlx.dao.impl.OrderInfoDaoImpl;
import com.hzlx.entity.BusinessInfo;
import com.hzlx.entity.FoodInfo;
import com.hzlx.entity.RespBean;
import com.hzlx.service.BusinessInfoService;
import com.hzlx.utils.MD5Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * OerDingFoodForWeb
 * 2023/4/5 10:51
 * 星期三
 */
public class BusinessInfoServiceImpl implements BusinessInfoService {
    /**DAO层
     *
     */
    private BusinessInfoDao businessInfoDao = new BusinessInfoDaoImpl();

    private OrderInfoDao orderInfoDao = new OrderInfoDaoImpl();

    private FoodInfoDao foodInfoDao = new FoodInfoDaoImpl();


    /**
     * 登录
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    @Override
    public String login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Content-Type","text/html; charset = UTF-8");
        //获取请求中的数据
        String userName=request.getParameter("userName");
        String pwd = request.getParameter("password");
        //密码加密
//        String pwdSalt = MD5Utils.encryptMD5AndSalt(MD5Utils.encryptMD5(pwd), "吃了喵");
        //调用service中的登录方法
        BusinessInfo businessInfo = businessInfoDao.selectBusinessInfoByUserNameAndPwd(userName, pwd);
        if (null!=businessInfo){
//            request.setAttribute("bName",businessInfo.getName());

            //把登录成功的商家信息方法session作用域中
            request.getSession().setAttribute("businessInfo",businessInfo);
            //登录成功妆发到home对应的servlet去台哦转红么.jsp
            return "/businessHome.do";
        }else {
            //登录失败？转发到login.jsp
            return "/pages/business/login.jsp";
        }
    }

    @Override
    public BusinessInfo login(String userName, String pwd) {
        //处理pwd 加密
        String pwdSalt = MD5Utils.encryptMD5AndSalt(MD5Utils.encryptMD5(pwd), "吃了喵");
        //DAO根据用户名和密码查询商家对象 ，如果数据库里有，则返回对应的对象，如果没有则返回null
        BusinessInfo businessInfo = businessInfoDao.selectBusinessInfoByUserNameAndPwd(userName, pwdSalt);
        return businessInfo;
    }

    @Override
    public String register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("password");
        String address = request.getParameter("address");
        String tel = request.getParameter("tel");

        BusinessInfo businessInfo = new BusinessInfo();
        businessInfo.setName(name);
        businessInfo.setUserName(userName);
        businessInfo.setPassword(passWord);
        businessInfo.setAddress(address);
        businessInfo.setTel(tel);
        if (businessInfoDao.insert(businessInfo)>0) {
            return "/pages/business/login.jsp";
        }else {
            response.setStatus(505);
            response.getWriter().write("error:The new failure!");
        }
        return null;
    }


    @Override
    public Integer checkUserName(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //设置请求请求编码格式为 UTF-8
        request.setCharacterEncoding("UTF-8");
        //获取请求参数
        String userName = request.getParameter("userName");
        if (userName.isEmpty()){
            //如果为空 返回-1 标识校验不通过
            return -1;
        }
        //根据用户名查询数据库，看是否重复的 如果有 返回查到的那个数字
        return  businessInfoDao.countBusinessInfoByUserName(userName);
    }


    /**
     * 跳转到商家的主页
     * @param req
     * @return
     */
    @Override
    public String goHome(HttpServletRequest req) {
        //从session中获取商家对象(当前登录的是哪个商家)
        BusinessInfo businessInfo = (BusinessInfo) req.getSession().getAttribute("businessInfo");
        //计算预计收入
        BigDecimal total_money = orderInfoDao.getExpectedIncome(businessInfo.getId());
        System.out.println(total_money);

        //待处理订单列表
        List<Map<String, Object>> pendingOrders = orderInfoDao.getPendingOrderList(businessInfo.getId());
        //计算待处理订单数
//        int pendingNum = pendingOrders.size();
        Long pendingNum = orderInfoDao.pending(businessInfo.getId());
        //往request作用域中存放数据
        //预 计收入
        req.setAttribute("totalMoney",total_money);
        //待处理订单列表
        req.setAttribute("pendingOrders",pendingOrders);
        //待处理订单数
        req.setAttribute("pendingNum",pendingNum);
        //订单编号
//        req.setAttribute("pendingNo");
        return "/pages/business/home.jsp";
    }


    @Override
    public String goOrder(HttpServletRequest req){
        //从session中获取商家对象(当前登录的是哪个商家)
        BusinessInfo businessInfo = (BusinessInfo) req.getSession().getAttribute("businessInfo");
        List<Map<String, Object>> orderLists = orderInfoDao.getOrderList(businessInfo.getId());
        req.setAttribute("pendingNos",orderLists);
        return "/pages/business/order.jsp";
    }

    @Override
    public String goOrderPro(HttpServletRequest req) {
        BusinessInfo businessInfo = (BusinessInfo) req.getSession().getAttribute("businessInfo");
        List<Map<String, Object>> orderLists = orderInfoDao.getOderPro(businessInfo.getId());
        req.removeAttribute("pendingNos");
        req.setAttribute("pendingNos",orderLists);
        return "/pages/business/order.jsp";
    }

    @Override
    public String goOrderCompleter(HttpServletRequest req,String status) {
        BusinessInfo businessInfo = (BusinessInfo) req.getSession().getAttribute("businessInfo");
        List<Map<String, Object>> orderLists = orderInfoDao.getOderComplete(businessInfo.getId(),status);
        req.setAttribute("pendingNos",orderLists);
        return "/pages/business/order.jsp";
    }



    @Override
    public String goSetting(HttpServletRequest req) {
        settingPublic(req);
        BusinessInfo businessInfo = (BusinessInfo) req.getSession().getAttribute("businessInfo");
        //获取订单月销数量
        Integer sum = orderInfoDao.getYueXiao(businessInfo.getId());
        //商家下所有菜品
        List<FoodInfo> foodInfos = foodInfoDao.selectFoodInfoAll(businessInfo.getId());
        req.setAttribute("foodInfos",foodInfos);
        req.setAttribute("sales",sum);
        req.setAttribute("bus_name",businessInfo.getName());
        return "/pages/business/setting.jsp";
    }

    @Override
    public String OffSetting(HttpServletRequest req) {
        settingPublic(req);
        //当前登录的商家
        BusinessInfo businessInfo = (BusinessInfo) req.getSession().getAttribute("businessInfo");
        //登录商家下已下架菜的集合
        List<FoodInfo> OffStringNumberList = foodInfoDao.selectFoodInfoList(businessInfo.getId());
        req.removeAttribute("foodInfos");
        req.setAttribute("foodInfos",OffStringNumberList);

        return "/pages/business/setting.jsp";
    }

    @Override
    public String onOffsetting(HttpServletRequest req) {
        settingPublic(req);
        RespBean respBean;
        System.out.println(req.getParameter("orderId"));
        //获取点击的商品id
        Integer orderId = Integer.parseInt(req.getParameter("orderId"));
        int num = foodInfoDao.onOffsetting(orderId);
        if (num>0){
            respBean =RespBean.success();
        }else {
            respBean = RespBean.error(1100,"修改订单状态失败");
        }
        Gson gson = new Gson();
        return gson.toJson(respBean);
    }

    @Override
    public void settingPublic(HttpServletRequest req) {
        BusinessInfo businessInfo = (BusinessInfo) req.getSession().getAttribute("businessInfo");
        //登录商家下已下架菜品数量
        Integer OffStringNumber = foodInfoDao.selectFoodInfoOff(businessInfo.getId());
        //商家下所有菜品
        List<FoodInfo> foodInfos = foodInfoDao.selectFoodInfoAll(businessInfo.getId());
        //商家下菜品数量
        int size = foodInfos.size();
        req.setAttribute("size",size);
        req.setAttribute("OffStringNumber",OffStringNumber);
    }
}
