package com.xmy.x2mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmy.common.utils.PageUtils;
import com.xmy.x2mall.member.entity.MemberCollectSubjectEntity;

import java.util.Map;

/**
 * 会员收藏的专题活动
 *
 * @author X2
 * @email xmy329@gmail.com
 * @date 2020-07-25 14:57:45
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

