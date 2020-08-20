package com.xmy.x2mall.order.dao;

import com.xmy.x2mall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author X2
 * @email xmy329@gmail.com
 * @date 2020-07-25 15:31:05
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
