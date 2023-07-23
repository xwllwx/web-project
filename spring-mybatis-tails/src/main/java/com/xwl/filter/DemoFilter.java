package com.xwl.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/login")
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("放行前的操作");
        //        Filter能看见所有请求和响应
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("放行后的操作");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
