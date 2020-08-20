package com.xmy.x2mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmy.common.utils.PageUtils;
import com.xmy.x2mall.product.entity.SkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author X2
 * @email xmy329@gmail.com
 * @date 2020-07-24 17:26:00
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

