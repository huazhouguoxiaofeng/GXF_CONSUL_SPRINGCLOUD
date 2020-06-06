package com.gxf.user.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ConfigurationProperties 从配置文件批量读取对象值，下面的两个注解就负责把这些东东放进容器里面
 * @Configuration、@Component 都是在项目启动的时候，跟spring说要扫描这个类，并放进容器里面，但是这两个注解是有区别的，具体我不清楚
 * @PropertySource("classpath:gxf.properties")
 *    1、没有这个注解的时候，默认读application.yml文件
 *    2、当配上了这个注解，就是默认从所配的指定路径里面读取了，如果该路径找不到文件，就报错了
 *    3、好奇怪，这个指定文件不能是yml文件，可以是properties文件，不知道为什么，这个问题搞了我好久
 *    4、要记得这个路径是默认从resources下面开始执行的
 * @Bean 项目启动的时候，跟spring说要调这个方法了
 * @Value("${xixi.haha:10086}")
 *    1、还有这个注解，就是最简单的从配置文件里面读取属性值了
 *    2、如果配置文件里面没有，就是这个默认值了，也就是说配置文件里面没有也不会报错的
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "guoxiao")
@AllArgsConstructor
@NoArgsConstructor
//@Component
@PropertySource("classpath:gxf.properties")
public class GuoXiaoProperties {
    private String feng;
    private String hui;
    private String ming;
    @Bean
    public void asfd(){
        System.out.println("项目启动时从特定的配置文件gxf.properties里面取出相关信息：" + feng);
    }
}
