package com.xmy.x2mall.product.vo;

import lombok.Data;

/**
 * Talk is cheap,show me the code.
 *
 * @Description:
 * @Author: X2
 * @Date: 2020/8/6 18:51
 */
@Data
public class AttrRespVo extends AttrVo {

    private String catelogName;

    private String groupName;

    private Long[] catelogPath;

}
