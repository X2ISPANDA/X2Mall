package com.xmy.x2mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmy.common.utils.PageUtils;
import com.xmy.x2mall.product.entity.AttrEntity;
import com.xmy.x2mall.product.vo.AttrGroupRelationVo;
import com.xmy.x2mall.product.vo.AttrRespVo;
import com.xmy.x2mall.product.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author X2
 * @email xmy329@gmail.com
 * @date 2020-07-24 17:26:00
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type);

    AttrRespVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attr);

    List<AttrEntity> getRelationAttr(Long attrgroupId);

    void deleteRelation(AttrGroupRelationVo[] vos);
}

