package com.ppretki.springsecuritydemo.security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(1000)
public class FirstWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    public FirstWebSecurityConfigurerAdapter(){
        super(true);
    }


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        log.info("configure");
        http.antMatcher("/a");
        http.antMatcher("/b");


        http.addFilterBefore(new CustomFilter("Filter A"), ChannelProcessingFilter.class);

        http.httpBasic();
    }
    @RequiredArgsConstructor
    private class CustomFilter implements Filter {

        private final String name;

        @Override
        public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
            log.info("doFilter: {}", name);
            chain.doFilter(request, response);
        }
    }
}
