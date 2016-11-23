package com.zyx.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by subdong on 16-1-14.
 */
@ComponentScan("com.zyx.scheduler.*")
@ImportResource(value = {"zyx-spring.xml"})
@SpringBootApplication
public class ZyxSchedulerMain extends WebMvcConfigurerAdapter implements EmbeddedServletContainerCustomizer {

    private static final int PORT = 18100;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ZyxSchedulerMain.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        /*UndertowServer undertowServer = new UndertowServer();
        undertowServer.setWebAppName("weixin");
        undertowServer.setPort(8000);
        undertowServer.setWebAppRoot(new PathResource("."));
        undertowServer.afterPropertiesSet();*/

        container.setPort(PORT);
    }
}
