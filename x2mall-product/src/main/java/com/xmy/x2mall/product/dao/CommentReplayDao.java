package com.xmy.x2mall.product.dao;

import com.xmy.x2mall.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author X2
 * @email xmy329@gmail.com
 * @date 2020-07-24 17:26:00
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {
	
}
