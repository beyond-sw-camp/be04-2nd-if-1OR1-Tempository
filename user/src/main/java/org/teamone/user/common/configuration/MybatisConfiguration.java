package org.teamone.user.common.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages  = "org.teamone.user", annotationClass = Mapper.class)
public class MybatisConfiguration {
}
