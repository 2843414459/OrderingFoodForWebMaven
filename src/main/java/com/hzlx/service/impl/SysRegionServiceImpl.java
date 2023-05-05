package com.hzlx.service.impl;

import com.google.gson.Gson;

import com.hzlx.entity.RespBean;
import com.hzlx.entity.SysRegion;
import com.hzlx.service.SysRegionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * OerDingFoodForWeb
 * 2023/4/11 10:46
 * 星期二
 *
 * @author 三级联动 service
 */
public class SysRegionServiceImpl implements SysRegionService {
    @Override
    public String queryAddres(HttpServletRequest req) {
        return null;
    }
    /**
     * service层  引入数据访问层(DAO)
     */
//    private SysRegionDao sysRegionDao = new SysRegionDaoImpl();

    /**
     * 业务层 查询地理位
     *
     * @param req
     * @return
     */
//    @Override
//    public String queryAddres(HttpServletRequest req) {
//        RespBean resp;//数据组装成RespBean
//        //获取请求参数
//        String parentId = req.getParameter("parentId");
//        //根据parentId查询对应的地理位置集合
//        List<SysRegion> addressList = sysRegionDao.getAddressByParentId(parentId);
//        if (addressList != null && addressList.size() > 0) {
//            //查到数据了，设置返回响应码为200，message为success  data为addressList
//            resp=RespBean.success(addressList);
//        }else {
//            //查不到数据，设置响应码为 10086 message为查询失败
//            resp = RespBean.error(10086,"查询失败");
//        }
//        //将组装好RespBean对象转成JSON字符串
//
//        return new Gson().toJson(resp);
//    }
}
