package com.Agrovest.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PageConfig implements WebMvcConfigurer {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/plannegocio").setViewName("plannegocio");
        registry.addViewController("/sobrenosotros").setViewName("sobrenosotros");
        registry.addViewController("/plan").setViewName("plan");
        registry.addViewController("/asesoria").setViewName("asesoria");
        registry.addViewController("/crear").setViewName("crear");
        registry.addViewController("/editar").setViewName("editar");
        registry.addViewController("/mostrar").setViewName("mostrar");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/signup").setViewName("signup");
        registry.addViewController("/panel").setViewName("panel");
        registry.addViewController("/requisitos").setViewName("requisitos");
        registry.addViewController("/tierra").setViewName("tierra");
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

}
