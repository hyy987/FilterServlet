package com.bjsxt.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 过滤器的使用：
 *      作用：
 *          对服务器接受的请求资源和响应资源进行管理。
 *          保护servlet
 * 使用：
 *      创建一个实现了Filter借口的普通java类
 *      覆写借口的方法“
 *      init方法：服务器启动即执行。资源初始化
 *      doFilter方法：拦截请求的方法，在此方法中可以对资源实现管理
 *          注意：
 *              需要手动对请求进行放行；filterChain.doFilter(servletRequest,servletResponse);
 *      destroy方法：服务器关闭的时候
 *      在web.xml中配置过滤器
 *      <!--配置过滤器-->
 *     <filter>
 *         <filter-name>filter</filter-name>
 *         <filter-class>类的全限定路径</filter-class>
 *     </filter>
 *     <filter-mapping>
 *         <filter-name>filter</filter-name>
 *         <url-pattern>/*</url-pattern>
 *     </filter-mapping>
 *     注意：
 *          url-pattern:/*
 *                  表示拦截所有请求
 *          url-pattern:*.do
 *                  表示所有以.do结尾的请求。一般是用来进行模块拦截处理
 *          url-pattern:/ts
 *                  表示拦截指定url的请求。针对某个servlet进行拦截，保护servlet。
 *
 *      过滤器的生命周期：
 *              服务器启动到服务器关闭‘
 *      总结：
 *          过滤器是程序员声明和配置，服务器根据请求中的uri信息调用
 *      执行：
 *          浏览器发送请求到服务器，服务器接到请求后，根据urI信息在web.xml中找到对应的过滤器执行doFilter方法，该方法对此次请求
 *          处理后如果符合要求则放行，放行后如果还有符合要求的过滤器则继续进行过滤，
 *          找到执行对应的servlet进行请求处理。servlet对请求处理完毕后，也就是service方法结束了。
 *          还需要继续返回相应的doFilter方法继续执行。
 *       案例：
 *          统一编码格式设置。
 *          session管理
 *          权限管理
 *          资源管理（统一水印，和谐词汇等等）
 */

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
            System.out.println("com.bjsxt.filter.MyFilter.init(我被初始化了)");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("com.bjsxt.filter.MyFilter.doFilter（我被执行了）");
        //设置编码格式
            servletRequest.setCharacterEncoding("utf-8");
            servletResponse.setContentType("text/html;charset=utf-8");
        //判断session
        HttpSession hs = ((HttpServletRequest) servletRequest).getSession();
        if(hs.getAttribute("user")==null){
            ((HttpServletResponse)servletResponse).sendRedirect("/a/login.jsp");
        }else{
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        }

        System.out.println("com.bjsxt.filter.MyFilter.doFilter（我被执行了2）");
    }

    @Override
    public void destroy() {

        System.out.println("com.bjsxt.filter.MyFilter.destroy（我被销毁了）");
    }
}
