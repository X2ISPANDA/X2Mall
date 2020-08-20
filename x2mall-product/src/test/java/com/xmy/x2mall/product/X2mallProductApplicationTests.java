package com.xmy.x2mall.product;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.xmy.x2mall.product.entity.BrandEntity;
import com.xmy.x2mall.product.service.BrandService;
import com.xmy.x2mall.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

@Slf4j
@SpringBootTest
class X2mallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Autowired
    OSSClient ossClient;

    @Autowired
    CategoryService categoryService;

    @Test
    public void testFindPath() {
        Long[] categoryPath = categoryService.findCatelogPath(225L);
        log.info("完整路径:{}", Arrays.asList(categoryPath));

    }

    @Test
    public void testUpload() throws FileNotFoundException {
//        // Endpoint以杭州为例，其它Region请按实际情况填写。
//        String endpoint = "oss-cn-shenzhen.aliyuncs.com";
//        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
//
//        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流。
        InputStream inputStream = new FileInputStream("C:\\Users\\xmy32\\Pictures\\test.md");

        ossClient.putObject("x2mall", "test.md", inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();

        System.out.println("上传完成");
    }

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setDescript("特靠谱");
        brandEntity.setName("tkp");
        brandService.save(brandEntity);
        System.out.println("保存成功...");
    }

}
