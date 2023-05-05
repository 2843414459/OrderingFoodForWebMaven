package com.hzlx.mapper;

import com.hzlx.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface OrderInfoMapper {




    BigDecimal getExpectedIncome(Integer id);

    List<Map<String, Object>> getPendingOrderList(int i);

    int updateOrderForStatus(@Param("orderNo") Integer orderNo,@Param("businessId") Integer businessId,@Param("status") int status);

    /**
     * 查询指定商家待处理订单数量
     * @param i
     * @return
     */
    Long pending(Integer i);

    List<Map<String,Object>> getOrderList(Integer id);

    List<Map<String, Object>> getOderPro(Integer id);

    List<Map<String, Object>> getOderComplete(@Param("id") Integer id,@Param("status") String status);

    Long getYueXiao(Integer id);
}