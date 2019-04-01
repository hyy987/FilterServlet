package com.bjsxt.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter3 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("com.bjsxt.filter.MyFilter3.doFilter(我是第三个过滤器)");
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
