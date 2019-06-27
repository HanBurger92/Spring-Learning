package com.hanburger92.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// 扩展AbstractAnnotationConfigDispatcherServletInitializer的任意类将自动配置Spring上下文
// 和DispatcherServlet
public class RepositoryWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // "/"标示它会是应用的默认Servlet，会处理进入应用的所有请求
    // 譬如静态资源，图片，样式表
    @Override
    protected String[] getServletMappings(){
        System.out.println("2222");
        return new String[]{ "/" };
    }

    // 配置驱动应用后端的中间层和数据层的Bean
    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class<?>[]{ RootConfig.class };
    }

    // 配置Web Bean：控制器，解析器
    @Override
    protected Class<?>[] getServletConfigClasses(){
        return new Class<?>[]{WebConfig.class};
    }

}