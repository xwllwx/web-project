package com.xwl.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter("/*")
public class AbcFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("放行前的操作");
        //        Filter能看见所有请求和响应
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("放行后的操作");
    }
}
