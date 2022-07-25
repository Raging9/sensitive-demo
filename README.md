##### 前端显示脱敏

- 核心注解 @SensitiveInfo

```java
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@JacksonAnnotationsInside
@JsonSerialize(
    using = SensitiveSerializer.class
)
public @interface SensitiveInfo {
    MaskModeEnum mode() default MaskModeEnum.FULL;

    Class<? extends IDataMaskHandler>[] handler() default {};
}
```

在实体类上需要脱敏的字段添加@SensitiveInfo注解，，添加自定义的电话号码处理器，返回json数据到前端时，会进行脱敏

```java
@Data
@TableName("t_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    @SensitiveInfo(handler = com.demo.handler.PhoneMaskHandler.class)
    private String phone;
}
```

```json
[
    {
        "id": 3,
        "name": "张三",
        "phone": "151****7415"
    }
]
```

##### 数据库存储脱敏

- 引入Sharding-JDBC 依赖

```xml
<dependency>
  <groupId>org.apache.shardingsphere</groupId>
  <artifactId>sharding-jdbc-spring-boot-starter</artifactId>
  <version>4.0.0-RC1</version>
</dependency>
```

- 配置文件

```yaml
spring:
  main:
    allow-bean-definition-overriding: true
  shardingsphere:
    datasource:
      names: ds
      ds:
        url: jdbc:mysql://localhost:3306/test?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
        type: com.alibaba.druid.pool.DruidDataSource
        username: root
        password: mysql
        driver-class-name: com.mysql.cj.jdbc.Driver
    encrypt:
      encryptors:
        encryptors_aes:
          type: aes #采用aes加密算法
          props:
            aes.key.value: 123456 
          qualified-columns: t_user.phone #加密的字段
      tables:
        t_user:
          columns:
            phone:
              cipherColumn: phone
              encryptor: encryptors_aes
    props:
      sql:
        show: true
      query:
        with:
          cipher:
            column: true
```
