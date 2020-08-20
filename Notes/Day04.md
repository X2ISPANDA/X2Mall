基本开发思路

启动人人后台管理发现后台管理的请求路径逻辑

![image-20200726162649254](https://i.loli.net/2020/07/26/jzbcOEh49LC7RQK.png)

即对应目录中如下视图

![image-20200726162915052](https://i.loli.net/2020/07/26/6QZgiXHJOkf5vRr.png)

我们只需定义路径，/会自动转成-，然后根据文件夹放好就行。

然后从role.vue中直接copy获取数据的逻辑，直接进行修改

```javascript
 methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/sys/role/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'roleName': this.dataForm.roleName
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
```

为了从不同的微服务中获取数据，我们需要在static/config/index.js中修改接口请求地址，而为了能从多个微服务中便捷的获取，我们直接填写为网关地址，由网关来进行分配。

```js
/**
 * 开发环境
 */
;(function () {
  window.SITE_CONFIG = {};

  // api接口请求地址
  window.SITE_CONFIG['baseUrl'] = 'http://localhost:88/api';

  // cdn地址 = 域名 + 版本号
  window.SITE_CONFIG['domain']  = './'; // 域名
  window.SITE_CONFIG['version'] = '';   // 版本号(年月日时分)
  window.SITE_CONFIG['cdnUrl']  = window.SITE_CONFIG.domain + window.SITE_CONFIG.version;
})();

```

然后将后台管理加入网关。

```yml
spring:
  cloud:
    gateway:
      routes:
        - id: admin_route
          uri: lb://renren-fast # lb:负载均衡
          predicates:
            - Path=/api/**
          filters:
            - RewritePath=/api/(?<segment>/?.*),/renren-fast/$\{segment}

## 前端项目,/api


```

## 跨域

浏览器对javascript施加的安全限制。

`同源策略：协议、域名、端口号都要相同，否则就会产生跨域。`

### 解决跨域

- 使用Nginx部署为同一域
- 配置当前请求允许跨域

```java
package com.xmy.x2mall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


/**
 * Talk is cheap,show me the code.
 *
 * @Description:
 * @Author: X2
 * @Date: 2020/7/26 17:43
 */
@Configuration
public class MyCorsConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //1.配置跨域
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.setAllowCredentials(true);

        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(source);
    }
}

```



通过element UI添加三级分类组件

`@RequestBody：获取请求体，必须发送POST请求，SpringMVC自动将请求体里的数据转为对应的对象。`

#### 逻辑删除

使用Mybatis-Plus的逻辑删除功能使得不从数据库里删除菜单

`修改时应注意写入的字段，避免写入默认值，要不就直接回显，要不就分离数据。`