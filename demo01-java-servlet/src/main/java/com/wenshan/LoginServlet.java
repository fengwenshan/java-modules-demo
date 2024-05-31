package com.wenshan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/user")
public class LoginServlet extends HttpServlet {

    public LoginServlet() {
        super();
        System.out.println("1. 无参构造方法执行了");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("2. init方法执行");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("-1. 服务器停止");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("4. service方法执行, 初始化会调用一次 与 客户端请求一次");
        // form-data 请求参数
        if(req.getMethod().equals("POST")) {
            // 检查这个字符串是否包含 某个字符串， java string中的方法 相当于js中的
            if(req.getContentType().contains("multipart/form-data")) {
                doPostFormData(req, res);
            } else {
                doPost(req, res);
            }

        }

    }


    public void doPostFormData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 确保请求体以正确的字符编码读取
        System.out.println("4. service方法执行, 初始化会调用一次 与 客户端请求一次");
        request.setCharacterEncoding("UTF-8");

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while( (line = reader.readLine() ) != null ) {
            // ----------------------------668359354298146319790586
            // Content-Disposition: form-data; name="username"
            //
            // 1231
            //         ----------------------------668359354298146319790586
            // Content-Disposition: form-data; name="password"
            //
            // 1231231231
            //         ----------------------------668359354298146319790586--
            System.out.println(line);
            stringBuilder.append(line);
        }




        // String body = stringBuilder.toString();
        // // ----------------------------315079387500524308683603Content-Disposition: form-data; name="username"1231----------------------------315079387500524308683603Content-Disposition: form-data; name="password"1231231231----------------------------315079387500524308683603--
        // System.out.println(body);
        // // multipart/form-data; boundary=--------------------------315079387500524308683603
        // System.out.println(request.getContentType());

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("5. doPost方法执行");
    }
}
