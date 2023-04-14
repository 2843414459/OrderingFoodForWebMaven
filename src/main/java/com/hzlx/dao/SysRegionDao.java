package com.hzlx.dao;

import com.hzlx.entity.SysRegion;

import java.util.List;

/**
 * OerDingFoodForWeb
 * 2023/4/11 10:44
 * 星期二
 */
public interface SysRegionDao {

    List<SysRegion> getAddressByParentId(String parentId);
}
