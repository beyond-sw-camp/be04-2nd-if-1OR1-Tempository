package org.teamone.projecttemplate.command.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "org.teamone.projecttemplate.command", annotationClass = Mapper.class)
public class JpaConfiguration {
}
