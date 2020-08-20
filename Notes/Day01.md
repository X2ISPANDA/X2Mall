# X2商城

- vagrant：使用虚拟机镜像快速创建虚拟机。

- Docker下配置Redis

  ```shell
  docker run --name myRedis --restart=always -p 6379:6379 -v /opt/myRedis/conf:/etc/redis -d redis redis-server /etc/redis/redis.conf
  ```

  > 参数说明：
  >
  > - --restart=always：跟随docker启动
  > - -v /opt/myRedis/conf:/etc/redis：将主机中的配置文件目录挂载到容器中，前面是主机后面是容器
  > - redis-server /etc/redis/redis.conf：使用挂载的文件启动
  
- 整合MybatisPlus

> 配置数据源：
>
> - 导入数据库驱动
> - yml配置
>
> 使用：
>
> @MapperScan

## Spring Cloud Alibaba

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-alibaba-dependencies</artifactId>
            <version>2.2.1.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

选择nacos作为注册中心

### 如何接入

在启动示例进行演示之前，我们先了解一下 Spring Cloud 应用如何接入 Nacos Discovery。 **注意 本章节只是为了便于您理解接入方式，本示例代码中已经完成接入工作，您无需再进行修改。**

1. 首先，修改 pom.xml 文件，引入 Nacos Discovery Starter。

   ```
    <dependency>
        <groupId>com.alibaba.cloud</groupId>
        <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
    </dependency>
   ```

2. 在应用的 /src/main/resources/application.properties 配置文件中配置 Nacos Server 地址

   ```yml
   spring:
      cloud:
       nacos:
         discovery:
           server-addr: 127.0.0.1:8848
     application:
       name: x2mall-member
   ```

3. 使用 @EnableDiscoveryClient 注解开启服务注册与发现功能

   ```
    @SpringBootApplication
    @EnableDiscoveryClient
    public class ProviderApplication {
   
    	public static void main(String[] args) {
    		SpringApplication.run(Application.class, args);
    	}
   
    	@RestController
    	class EchoController {
    		@GetMapping(value = "/echo/{string}")
    		public String echo(@PathVariable String string) {
    				return string;
    		}
    	}
    }
   ```

## Feign实现远程调用

1. 引入openFeign

2. 编写一个接口告诉Spring Cloud这个接口需要调用远程服务。

   1. 声明接口的每一个方法都是调用哪个远程服务的哪个请求

   ```java
   @FeignClient("x2mall-coupon")
   public interface CouponFeignService {
   
       @RequestMapping("/coupon/coupon/member/list")
       public R memberCoupons();
   }
   ```

   

3. 开启远程调用功能

   ```java
   @SpringBootApplication
   @EnableDiscoveryClient
   @EnableFeignClients(basePackages = "com.xmy.x2mall.member.feign")
   public class X2mallMemberApplication {
   
       public static void main(String[] args) {
           SpringApplication.run(X2mallMemberApplication.class, args);
       }
   
   }
   ```

4. 进行使用

   ```java
   @RequestMapping("/coupons")
       public R test() {
           MemberEntity memberEntity = new MemberEntity();
           memberEntity.setNickname("张三");
           R r = couponFeignService.memberCoupons();
           return R.ok().put("member", memberEntity).put("coupons", r.get("coupons"));
       }
   ```

## Feign配置中心

1. 引入依赖

   ```xml
    <dependency>
        <groupId>com.alibaba.cloud</groupId>
        <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
    </dependency>
   ```

2. 在应用的 /src/main/resources/`bootstrap.properties` 配置文件中配置 Nacos Config 元数据

   ```properties
   spring.application.name=nacos-config-example
   spring.cloud.nacos.config.server-addr=127.0.0.1:8848
   ```

3. 完成上述两步后，应用会从 Nacos Config 中获取相应的配置，并添加在 Spring Environment 的 PropertySources 中。这里我们使用 @Value 注解来将对应的配置注入到 SampleController 的 userName 和 age 字段，并添加 @RefreshScope 打开动态刷新功能

   ```java
    @RefreshScope
    class SampleController {
   
    	@Value("${user.name}")
    	String userName;
   
    	@Value("${user.age}")
    	int age;
    }
   ```

4. 在控制中心添加配置，创建一个数据集（Data ID），名字为应用名.properties，`使用properties文件，yml暂时测试失败`

![image-20200707021453690](https://i.loli.net/2020/07/07/zm4PUj2tBsQeguS.png)

5. 同时加载多个配置集

   ```properties
   spring.cloud.nacos.config.extension-configs[0].data-id=datasource.yml
   spring.cloud.nacos.config.extension-configs[0].group=dev
   spring.cloud.nacos.config.extension-configs[0].refresh=true
   
   spring.cloud.nacos.config.extension-configs[1].data-id=mybatis.yml
   spring.cloud.nacos.config.extension-configs[1].group=dev
   spring.cloud.nacos.config.extension-configs[1].refresh=true
   
   spring.cloud.nacos.config.extension-configs[2].data-id=other.yml
   spring.cloud.nacos.config.extension-configs[2].group=dev
   spring.cloud.nacos.config.extension-configs[2].refresh=true
   
   spring.cloud.nacos.config.extension-configs[3].data-id=x2mall-coupon.properties
   spring.cloud.nacos.config.extension-configs[3].group=dev
   spring.cloud.nacos.config.extension-configs[3].refresh=true
   
   ```

   ![image-20200707024459583](https://i.loli.net/2020/07/07/rU6fAJTCsyOizMp.png)

细节：

1. 命名空间：配置隔离。默认：public(保留空间)；切换命名空间添加属性：

   ```properties
   spring.cloud.nacos.config.namespace=771535b6-dea6-4135-b7ae-9e118fad2117
   //使用命名空间ID
   ```

   用处：1.开发生产测试环境隔离2.每一个微服务之间互相隔离配置，每一个微服务都创建自己的命名空间。

2. 配置集：所有配置的集合。

3. 配置集ID：类似文件名，Data ID

4. 配置分组：默认属于DEFAULT_GROUP,不同时期使用不同的配置。添加属性：

   ```properties
   spring.cloud.nacos.config.group=1111
   ```



