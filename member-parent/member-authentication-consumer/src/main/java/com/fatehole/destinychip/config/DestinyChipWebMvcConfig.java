package com.fatehole.destinychip.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author FateCat
 * @version 1.0.0
 * @date Create in 2020/11/02/16:52
 */
@Configuration
public class DestinyChipWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // 浏览器访问的地址
        String urlPath = "/auth/member/reg/page";

        // 目标视图的名称
        String viewName = "member-reg";

        registry.addViewController(urlPath).setViewName(viewName);

    }
}
