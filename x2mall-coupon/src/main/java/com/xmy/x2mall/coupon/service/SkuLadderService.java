package com.xmy.x2mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmy.common.utils.PageUtils;
import com.xmy.x2mall.coupon.entity.SkuLadderEntity;

import java.util.Map;

/**
 * 商品阶梯价格
 *
 * @author X2
 * @email xmy329@gmail.com
 * @date 2020-07-24 19:35:49
 */
public interface SkuLadderService extends IService<SkuLadderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

