package com.hzlx.dao.impl;

import com.hzlx.dao.BaseDao;
import com.hzlx.dao.OrderInfoDao;
import com.hzlx.entity.OrderInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * OerDingFoodForWeb
 * 2023/4/10 10:05
 * 星期一
 */
public class OrderInfoDaoImpl extends BaseDao<OrderInfo> implements OrderInfoDao {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(OrderInfo record) {
        return 0;
    }

    @Override
    public int insertSelective(OrderInfo record) {
        return 0;
    }

    @Override
    public OrderInfo selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(OrderInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(OrderInfo record) {
        return 0;
    }

    @Override
    public BigDecimal getExpectedIncome(Integer id) {
        String sql = "SELECT sum(total_money) as totalMoney  FROM t_order_info" +
                " WHERE `status` !=0 " +
                "AND business_id =? " +
                "AND DATE_FORMAT(create_time, '%Y-%m-%d') = DATE_FORMAT(NOW(), '%Y-%m-%d');";
        Map<String, Object> map = executeQueryMap(sql, id);
        return (BigDecimal) map.get("totalMoney");
    }

    @Override
    public List<Map<String, Object>> getPendingOrderList(int id) {
        String sql = "SELECT * FROM t_order_info" +
                " WHERE `status` =3 " +
                "AND business_id = ? " +
                "AND DATE_FORMAT(create_time, '%Y-%m-%d') = DATE_FORMAT(NOW(), '%Y-%m-%d');";
        return executeQueryListMap(sql,id);
    }

    @Override
    public int updateOrderForStatus(Integer orderNo,Integer businessID , int status) {
        String sql = "update t_order_info set `status` =? where id = ? and business_id = ?";
        return executeUpdate(sql,status,orderNo,businessID);
    }


    /**
     * 查询指定商家待处理订单的数量
     * @param businessId
     * @return
     */
    @Override
    public Long pending(Integer businessId) {
        String sql = "SELECT count(1) as pendingNum FROM t_order_info" +
                " WHERE `status` > 1 " +
                "AND business_id = ? " +
                "AND DATE_FORMAT(create_time, '%Y-%m-%d') = DATE_FORMAT(NOW(), '%Y-%m-%d');";
        Map<String, Object> map = executeQueryMap(sql, businessId);
        return (Long) map.get("pendingNum");
    }

    @Override
    public List<Map<String, Object>> getOrderList(Integer id) {
        String sql = "SELECT * FROM t_order_info" +
                " WHERE `status` !=0 " +
                "AND business_id = ? " +
                "AND DATE_FORMAT(create_time, '%Y-%m-%d') = DATE_FORMAT(NOW(), '%Y-%m-%d');";
        return executeQueryListMap(sql,id);
    }

    @Override
    public List<Map<String, Object>> getOderPro(Integer id) {
        String sql = "SELECT * FROM t_order_info" +
                " WHERE `status` =2 " +
                "AND business_id = ? " +
                "AND DATE_FORMAT(create_time, '%Y-%m-%d') = DATE_FORMAT(NOW(), '%Y-%m-%d');";
        return executeQueryListMap(sql,id);
    }

    @Override
    public List<Map<String, Object>> getOderComplete(Integer id, String status) {
        String sql = "SELECT * FROM t_order_info" +
                " WHERE `status` =1 " +
                "AND business_id = ? " +
                "AND DATE_FORMAT(create_time, '%Y-%m-%d') = DATE_FORMAT(NOW(), '%Y-%m-%d');";
        return executeQueryListMap(sql,id);
    }

    @Override
    public Integer getYueXiao(Integer id) {
        String sql ="select count(1) as count\n" +
                "from t_order_info\n" +
                "where  \n" +
                "      business_id=? and\n" +
                "      date_format(create_time,'%Y-%m-%d') >= date_sub(curdate(),interval 30 day )";
        Map<String, Object> stringObjectMap = executeQueryMap(sql, id);
        Long count = (Long) stringObjectMap.get("count");
        return Math.toIntExact(count);
    }
}
