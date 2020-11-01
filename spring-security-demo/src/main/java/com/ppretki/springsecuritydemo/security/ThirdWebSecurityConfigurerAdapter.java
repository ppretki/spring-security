package com.ppretki.springsecuritydemo.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(1003)
public class ThirdWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    public ThirdWebSecurityConfigurerAdapter(){
        super(true);
    }


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        log.info("configure");
    }
}
