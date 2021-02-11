package io.learn.springcore.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"io.learn.springcore"})
@PropertySource("classpath:application.properties")
public class AppConfig {

}
