package com.hzlx.mapper;

import com.hzlx.entity.BusinessInfo;
import org.apache.ibatis.annotations.Param;

public interface BusinessInfoMapper {
    /**
     * 根据ID删除商家
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 商家的新增
     * @param record
     * @return
     */
    int insert(BusinessInfo record);

    /**
     * 根据id查询商家信息
     * @param id
     * @return
     */
    BusinessInfo selectByPrimaryKey(Integer id);

    /**
     * 根据账号密码查询商家
     * @param userName 账号
     * @param pwd 密码
     * @return 商家
     */
    BusinessInfo selectBusinessInfoByUserNameAndPwd(@Param("userName") String userName,@Param("password") String pwd);

    /**
     * 查询指定用户名出现次数
     * @param userName 用户名
     * @return 出现次数
     */
    int countBusinessInfoByUserName(String userName);

    /**
     * 修改商户信息
     * @param businessInfo
     * @return
     */
    int updateBusinessInfo(BusinessInfo businessInfo);

    /**
     * 更改营业状态
     * @param jobType  营业状态
     * @param id 商户ID
     * @return 受影响行数
     */
    int updateBusinessInfoForJobType(@Param("jobType") Integer jobType,@Param("id") Integer id);

    /**
     * 商户修改密码
     * @param newPwd  新密码
     * @param id 商户ID
     * @return 受影响行数
     */
    int updateBusinessInfoForPwd(@Param("newPwd") String newPwd,@Param("id") Integer id);


}