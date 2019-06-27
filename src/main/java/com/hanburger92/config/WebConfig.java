package com.hanburger92.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
// 启用SpringMVC
@EnableWebMvc
// 启用组件扫描，在com.hanburger92中扫描Bean
@ComponentScan("com.hanburger92")
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void setApplicationContext(final ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }

    // 配置静态资源处理，要求DispatcherServlet将静态资源的请求
    // 发到Servlet容器的默认Servlet上而不是以其本身处理资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }

    // 利用Apache Tiles视图定义布局
    // 配置Tiles视图解析器
    @Bean
    public TilesConfigurer tilesConfigurer(){
        System.out.println("2");
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        // 指定Tile定义的位置
        tilesConfigurer.setDefinitions("/WEB-INF/**/tiles.xml");
        // 启用刷新功能
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    // 配置Tiles视图解析器
    // 此解析器将会将逻辑视图名称解析为引用Tile定义的视图
    // 通过查找与逻辑视图名称相匹配的Tile定义实现该功能

    @Bean
    public ViewResolver viewResolver(){
        System.out.println("3");
        return new TilesViewResolver();
    }


    //配置Thymeleaf的视图解析器
    /*
    @Bean
    public ThymeleafViewResolver viewResolver1(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        // 在4.2.4或者更新版本中启用Spring EL compiler可以在大多数情况下加速执行速度
        // 但在某些情况下不太适合使用（譬如模版被不同的数据类型重复使用），所以默认为false
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        templateResolver().setApplicationContext(applicationContext);
        templateResolver().setPrefix("/WEB-INF/template");
        templateResolver().setSuffix(".html");
        templateResolver().setTemplateMode(TemplateMode.HTML);
        templateResolver().setCacheable(true);
        return templateResolver();
    }
     */
}