package com.xmy.x2mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmy.x2mall.common.utils.PageUtils;
import com.xmy.x2mall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author xmy
 * @email xmy329@gmail.com
 * @date 2021-06-10 14:08:22
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

