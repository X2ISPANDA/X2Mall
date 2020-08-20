package com.xmy.common.constant;

import lombok.Data;

/**
 * Talk is cheap,show me the code.
 *
 * @Description:
 * @Author: X2
 * @Date: 2020/8/13 17:52
 */

public class ProductConstant {

    public enum AttrEnum {
        /**
         * 基本属性
         */
        ATTR_TYPE_BASE(1,"基本属性"),

        /**
         * 销售属性
         */
        ATTR_TYPE_SALE(0, "销售属性");

        AttrEnum(int code, String message) {
            this.code = code;
            this.message = message;
        }

        /**
         * 值
         */
        private int code;
        /**
         * 信息
         */
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
