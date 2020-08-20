## 文件上传

`阿里云对象存储OSS`

服务器签名后直传阿里云

![image-20200802155437590](https://i.loli.net/2020/08/02/Mj1AEruT6b32YmR.png)

SDK [API文档](https://github.com/alibaba/aliyun-spring-boot)

校验需要进行前后端校验。避免通过PostMan发送。



## JSR303

1. 给Bean添加校验注解，并定义自己的Message提示

   > 在需要校验的地方开启：@Valid
   >
   > @NotNull @Future @Email....

2. 给校验的bean后紧跟一个BindingResult，就可以获取到校验的结果

3. 分组校验

   需要创建不同分组的接口，不需要方法也不需要实现。

   ```java
   	@NotNull(message = "修改必须指定品牌ID",groups = {UpdateGroup.class})
   	@Null(message = "新增不能指定ID",groups = {AddGroup.class})
   	@TableId
   	private Long brandId;
   ```

   使用@Validated注解

   ```java
    	@RequestMapping("/update")
       //@RequiresPermissions("product:brand:update")
       public R update(@Validated({UpdateGroup.class}) @RequestBody BrandEntity brand) {
           brandService.updateById(brand);
   
           return R.ok();
       }
   ```

   默认没有指定分组的校验注解在分组校验情况下不生效，只会在不分组的校验情况下生效。

### 自定义校验注解

1. 编写一个自定义的校验注解

   ```java
   package com.xmy.common.valid;
   
   import javax.validation.Constraint;
   import javax.validation.Payload;
   import java.lang.annotation.*;
   
   /**
    * Talk is cheap,show me the code.
    *
    * @Description:
    * @Author: X2
    * @Date: 2020/8/4 0:20
    */
   @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
   @Retention(RetentionPolicy.RUNTIME)
   @Documented
   @Constraint(
           validatedBy = {ListValueConstraintValidator.class}//自定义的校验器,可以指定多分校验器
   )
   public @interface ListValue {
       String message() default "{com.xmy.common.valid.ListValue.message}";//自定义的提示消息，编写配置文件ValidationMessages.Properties
   
       Class<?>[] groups() default {};
   
       Class<? extends Payload>[] payload() default {};
   
       int[] values() default {};//校验的数据
   
   }
   
   ```

   ```properties
   com.xmy.common.valid.ListValue.message=必须提交指定的值
   ```

   

2. 编写一个自定义的校验器

   ```java
   package com.xmy.common.valid;
   
   
   import javax.validation.ConstraintValidator;
   import javax.validation.ConstraintValidatorContext;
   import java.util.HashSet;
   import java.util.Set;
   
   /**
    * Talk is cheap,show me the code.
    *
    * @Description:
    * @Author: X2
    * @Date: 2020/8/4 0:30
    */
   public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {
   
       private Set<Integer> set = new HashSet<>();
   
       //初始化方法
       @Override
       public void initialize(ListValue constraintAnnotation) {
           int[] values = constraintAnnotation.values();
           for (int value : values) {
               set.add(value);
           }
       }
   
       //判断是否校验成功
   
       /**
        * @param integer  需要校验的值
        * @param constraintValidatorContext
        * @return
        */
       @Override
       public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
           return set.contains(integer);
       }
   }
   
   ```

   

3. 关联自定义的校验器和自定义的校验注解

## 父子组件传递数据

1. 子组件给父组件传递数据，事件机制。

   子组件给父组件发送一个事件，携带上数据。

   ```vue
   this.$emit("tree-node-click//事件名", data, node, component//携带的数据);
   ```

   ```html
   <category @tree-node-click="treeNodeClick"></category>
   ```



我们不想要当某个字段为空集合的数据，使用@JsonInclude