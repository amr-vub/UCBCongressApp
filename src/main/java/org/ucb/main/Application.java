package org.ucb.main;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.ucb.service.IServiceStub;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		
		IServiceStub iServiceStub = (IServiceStub) applicationContext.getBean("serviceStub");
		
        SpringApplication.run(Application.class, args);
    }
}