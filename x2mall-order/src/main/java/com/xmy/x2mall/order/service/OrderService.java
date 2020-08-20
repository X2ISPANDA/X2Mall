package com.xmy.x2mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmy.common.utils.PageUtils;
import com.xmy.x2mall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author X2
 * @email xmy329@gmail.com
 * @date 2020-07-25 15:31:05
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

