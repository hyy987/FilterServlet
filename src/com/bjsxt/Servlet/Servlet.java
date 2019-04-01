package com.bjsxt.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "Servlet",value = "/filter.do")
public class Servlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式

        //设置响应编码格式

        //获取请求信息
        //处理请求信息
        resp.getWriter().write("filter");
        //响应处理结果
    }
}
