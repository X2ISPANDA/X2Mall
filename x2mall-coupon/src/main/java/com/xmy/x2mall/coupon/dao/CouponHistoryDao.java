package com.xmy.x2mall.coupon.dao;

import com.xmy.x2mall.coupon.entity.CouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author X2
 * @email xmy329@gmail.com
 * @date 2020-07-24 19:35:49
 */
@Mapper
public interface CouponHistoryDao extends BaseMapper<CouponHistoryEntity> {
	
}
