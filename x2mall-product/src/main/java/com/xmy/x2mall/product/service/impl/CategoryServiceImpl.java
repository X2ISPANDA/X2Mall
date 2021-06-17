package com.xmy.x2mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xmy.x2mall.common.utils.PageUtils;
import com.xmy.x2mall.common.utils.Query;
import com.xmy.x2mall.product.dao.CategoryDao;
import com.xmy.x2mall.product.entity.CategoryEntity;
import com.xmy.x2mall.product.service.CategoryService;
import com.xmy.x2mall.product.vo.CategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryVo> listWithTree() {
        //1.query all categories
        List<CategoryEntity> entities = baseMapper.selectList(null);
        List<CategoryVo> vos=entities.stream().map(e ->{
            CategoryVo vo = new CategoryVo();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).collect(Collectors.toList());
        List<CategoryVo> collect = vos.stream().filter(categoryVo -> {
            return categoryVo.getParentCid() == 0;
        }).map((menu) -> {
            menu.setChildrens(getChildrens(menu, vos));
            return menu;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        //2.Assemble into a parent-child tree structure
        return collect;
    }

    public List<CategoryVo> getChildrens(CategoryVo categoryVo,List<CategoryVo> vos) {
        List<CategoryVo> collect = vos.stream().filter(v ->{
            return v.getParentCid().equals(categoryVo.getCatId());
        }).map(vo ->{
            vo.setChildrens(getChildrens(vo, vos));
            return vo;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        return collect;
    }

}
