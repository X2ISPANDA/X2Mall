##  Gateway

- **Route路由**: The basic building block of the gateway. It is defined by an ID, a destination URI, a collection of predicates, and a collection of filters. A route is matched if the aggregate predicate is true.
- **Predicate断言**: This is a [Java 8 Function Predicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html). The input type is a [Spring Framework `ServerWebExchange`](https://docs.spring.io/spring/docs/5.0.x/javadoc-api/org/springframework/web/server/ServerWebExchange.html). This lets you match on anything from the HTTP request, such as headers or parameters.
- **Filter过滤器**: These are instances of [Spring Framework `GatewayFilter`](https://docs.spring.io/spring/docs/5.0.x/javadoc-api/org/springframework/web/server/GatewayFilter.html) that have been constructed with a specific factory. Here, you can modify requests and responses before or after sending the downstream request.

如果引用父项目依赖，记住剔除spring-boot-starter-web依赖。

```xml
<dependency>
            <groupId>com.xmy.x2mall</groupId>
            <artifactId>x2mall-common</artifactId>
            <version>0.0.1-SNAPSHOT</version>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-web</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
```

```java
package com.xmy.x2mall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class X2mallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(X2mallGatewayApplication.class, args);
    }

}

```

```properties
spring.application.name=x2mall-gateway
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848
server.port=88
```



```yml
spring:
  cloud:
    gateway:
      routes:
        - id: qq_route
          uri: https://www.qq.com
          predicates:
            - Query=url,qq

        - id: baidu_route
          uri: https://www.baidu.com
          predicates:
            - Query=url,baidu
```

```url
http://localhost:88/hello?url=baidu
```

## ES6

`ECMAScript`，是浏览器脚本语言的规范。JavaScript是ES的实现。

`let声明变量`

- let有严格局部作用域
- let只能声明一次
- let不存在变量提升,即不能在声明之前调用

`const声明常量`

解构表达式

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=<device-width>, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <script>
        let arr = [1,2,3];

        // let a = arr[0];
        // let b = arr[1];
        // let c = arr[2];

        let[a,b,c] = arr;

        console.log(a,b,c);
    </script>
</body>
</html>
```

字符串扩展

- 使用\`   \`使字符串分行。
- 使用\${}在字符串中插入变量
- 不定参数
- 箭头函数，this不能使用
- 默认参数设置

对象优化

- 新增API，keys，values，entries。
- 声明对象简写，当对象的变量和已声明的变量变量名一致时。
- 对象拓展运算符，可以通过...对象名把该对象里所有的值赋值给另一个对象。

Pomise then异步编排

模块化

## VUE

### MVVM

### vue管控元素

声明式渲染/双向绑定/事件处理

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=<device-width>, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <div id="app">

        <input type="text" v-model="num">
        <!-- 事件处理 -->
        <button v-on:click="num++">点赞</button>
        <button v-on:click="cancel">取消</button>
        <h1>
            {{name}}，非常帅！有{{num}}个人为他点赞
        </h1>
    </div>
    <script src="./node_modules/vue/dist/vue.js"></script>

    <script>
        //1.声明式渲染
        let vm = new Vue({
            el: "#app",//绑定一个元素
            data: {//封装数据
                name: "熊铭钰",
                num: 9999
            },
            methods: {//封装方法
                cancel() {
                    this.num--;
                }
            }
        });
        //2.双向绑定
    </script>
</body>

</html>
```

- v-html/v-text:对从vue中取出的值进行处理，可以避免插值闪烁，避免因为网速慢出现表达式
- v-bind：使标签体内的属性可以通过vue动态取值，单向绑定
- v-model：双向绑定，主要用于表单项
- v-on
- v-for:v-for="(user,index) in users"添加:key=唯一的值，区分数据 
- v-if/v-else/v-else-if：根据判断是否显示元素，html代码直接删除
- v-show:根据判断是否显示元素，html还在

事件修饰符

- stop：防止冒泡到父元素
- prevent：阻止默认行为

按键修饰符：相当于快捷键功能。

