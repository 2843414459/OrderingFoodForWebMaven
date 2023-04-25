package com.hzlx.mapper;

import com.hzlx.entity.BusinessInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * OrderingFoodForWebMaven
 * 2023/4/25 16:08
 * 星期二
 */
@Mapper
public interface BusinessInfoMapper {
    BusinessInfo selectBusinessInfoByUserNameAndPwd(String userName, String pwd);
}
