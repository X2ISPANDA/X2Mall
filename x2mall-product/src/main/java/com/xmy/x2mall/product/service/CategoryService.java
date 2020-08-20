package com.xmy.x2mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmy.common.utils.PageUtils;
import com.xmy.x2mall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author X2
 * @email xmy329@gmail.com
 * @date 2020-07-24 17:25:59
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> asList);

    Long[] findCatelogPath(Long catelogId);

    void updateCascade(CategoryEntity category);
}

