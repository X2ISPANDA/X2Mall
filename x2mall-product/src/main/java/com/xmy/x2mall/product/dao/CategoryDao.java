package com.xmy.x2mall.product.dao;

import com.xmy.x2mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author X2
 * @email xmy329@gmail.com
 * @date 2020-07-24 17:25:59
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
