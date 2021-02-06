package io.learn.springcore;

import io.learn.springcore.configuration.AppConfig;
import io.learn.springcore.service.SimpleService;
import io.learn.springcore.service.SimpleServiceOtherImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SimpleService service = context.getBean(SimpleService.class);
        service.doTask();
        SimpleService otherService = context.getBean(SimpleServiceOtherImpl.class);
        otherService.doTask();
    }
}
