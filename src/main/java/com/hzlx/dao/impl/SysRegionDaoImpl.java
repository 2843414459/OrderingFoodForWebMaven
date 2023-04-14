package com.hzlx.dao.impl;

import com.hzlx.dao.BaseDao;
import com.hzlx.dao.SysRegionDao;
import com.hzlx.entity.SysRegion;

import java.util.List;

/**
 * OerDingFoodForWeb
 * 2023/4/11 10:44
 * 星期二
 * @author laogengt_order_detail_info
 */
public class SysRegionDaoImpl extends BaseDao<SysRegion> implements SysRegionDao {
    @Override
    public List<SysRegion> getAddressByParentId(String parentId) {
        String sql = "select * from sys_region where parent_id = ?";
        return executeQuery(sql,SysRegion.class,parentId);
    }
}
