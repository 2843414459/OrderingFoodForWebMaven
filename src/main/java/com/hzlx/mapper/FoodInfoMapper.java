package com.hzlx.mapper;



import com.hzlx.entity.FoodInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface FoodInfoMapper {
    /**
     * 根据businessId查询商家下所有的菜
     * @param businessId 商家ID
     * @return businessID对应的所有菜品
     */
    List<FoodInfo> selectFoodInfoAll(Integer businessId);

    /**
     * 菜品的新增
     * @param businessId  商家ID
     * @param name 菜品名字
     * @param price 菜品单价
     * @return 受影响行数
     */
    int insertFoodInfo(@Param("businessId") Integer businessId,@Param("name") String name,@Param("price") BigDecimal price);

    /**
     * 修改菜品信息
     * @param foodInfo
     * @return
     */
    int updateFoodInfoForPrice(FoodInfo foodInfo);

    /**
     * 根据ID售罄菜品
     * @param id
     * @return
     */
    int updateFoodInfoSoldOut(@Param("id") Integer id,@Param("newMent") Integer newMent);

    /**
     * 根据ID删除指定的菜品
     * @param id
     * @return
     */
    int deleteFoodInfoById(Integer id);


    /**
     * 根据商家名字模糊查询所有的菜
     * @param bName 根据名字
     * @return
     */
    List<Map<String , Object>> getFoodInfos(@Param("bName") String bName,@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);

    /**
     * 根据商家名字模糊查询所有总数
     * @param bName 商家名字
     * @return
     */
    Integer countFoodInfosByBName(String bName);

    /**
     * 根据商家id查询商家下以下架商品的数量
     * @param id
     * @return
     */
    Long selectFoodInfoOff(Integer id);

    /**
     * 根据商家id查询下已下架商品的集合
     * @param id
     * @return
     */
    List<FoodInfo> selectFoodInfoList(Integer id);

    int onOffsetting(Integer orderId);

    int onAddsetting(Integer orderId);
}