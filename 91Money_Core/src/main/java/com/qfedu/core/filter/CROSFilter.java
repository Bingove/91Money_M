package com.qfedu.core.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@Author Bingove
 *@Date Created in 2018/7/25 10:12
 */
//@Order(1)
//@WebFilter(filterName = "cros",urlPatterns = "/*")
public class CROSFilter implements Filter {
    //初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("cros已经启动");
    }
    //过滤
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //需要传递数据不能设置为* 不然会引起冲突 和 4
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
        response.setHeader("Access-Control-Allow-Credentials","true");//4
        filterChain.doFilter(servletRequest,response);
    }
    //销毁
    @Override
    public void destroy() {

    }
}
