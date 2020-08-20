package com.xmy.x2mall.coupon.dao;

import com.xmy.x2mall.coupon.entity.CouponSpuRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 * 
 * @author X2
 * @email xmy329@gmail.com
 * @date 2020-07-24 19:35:48
 */
@Mapper
public interface CouponSpuRelationDao extends BaseMapper<CouponSpuRelationEntity> {
	
}
