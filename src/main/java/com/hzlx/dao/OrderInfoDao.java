package com.hzlx.dao;

import com.hzlx.entity.OrderInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface OrderInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    BigDecimal getExpectedIncome(Integer id);

    List<Map<String, Object>> getPendingOrderList(int i);

    int updateOrderForStatus(Integer orderNo,Integer businessID, int i);

    /**
     * 查询指定商家待处理订单数量
     * @param i
     * @return
     */
    Long pending(Integer i);

    List<Map<String,Object>> getOrderList(Integer id);

    List<Map<String, Object>> getOderPro(Integer id);

    List<Map<String, Object>> getOderComplete(Integer id,String status);

    Integer getYueXiao(Integer id);
}