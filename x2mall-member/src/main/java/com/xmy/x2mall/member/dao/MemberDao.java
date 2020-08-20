package com.xmy.x2mall.member.dao;

import com.xmy.x2mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author X2
 * @email xmy329@gmail.com
 * @date 2020-07-25 14:57:46
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
