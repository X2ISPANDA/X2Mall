package com.xmy.x2mall.member.feign;

import com.xmy.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Talk is cheap,show me the code.
 *
 * @Description:
 * @Author: X2
 * @Date: 2020/7/25 17:25
 */
@FeignClient("x2mall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();
}
