package com.wenshan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
                System.out.println("multipart/form-data");
                doPostFormData(req, res);
            } else if(req.getContentType().equals("application/x-www-form-urlencoded")) {
                System.out.println("application/x-www-form-urlencoded");
                doPost(req, res);
            } else {
                System.out.println(req.getContentType());
                System.out.println("post else");
            }

        }

    }


    public void doPostFormData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 确保请求体以正确的字符编码读取
        request.setCharacterEncoding("UTF-8");
        // 获取边界
        String reqContentType = request.getContentType().substring("multipart/form-data; boundary=".length());

        BufferedReader reader = request.getReader();
        String line = null;
        Map<String, String> keyValueMap = new HashMap<>();
        String currentKey = null;
        while( (line = reader.readLine()) != null) {
            if(!line.isEmpty()) {
                if(line.equals("--" + reqContentType)) {
                    System.out.println("<======= start");
                } else if(line.equals("--" + reqContentType + "--")) {
                    System.out.println("=======> end");
                } else {
                    if(currentKey != null && line.trim() != "") {
                        keyValueMap.put(currentKey, line);
                        currentKey = null;
                    } else if(line.startsWith("Content-Disposition: form-data; name=")){
                        String key = line.substring("Content-Disposition: form-data; name=".length()+1, line.length() - 1);
                        currentKey = key;
                    } else {
                        System.out.println(line);
                    }
                }
            }
        }
        System.out.println(keyValueMap);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        res.setContentType("text/html;charset=UTF-8");
        // 拿取输出流
        PrintWriter out = res.getWriter();
        if(username.equals("lisi") && password.equals("123456")) {
            out.write("<h1> 登录成功 </h1>");
        } else {
            out.write("<h1 style=\" color: red;\"> 登录失败 </h1>");
            out.write("<a href=\"/java-web/login-jsp.html\">重新登录</a>");
        }
    }
}
