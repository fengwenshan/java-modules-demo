<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wenshan.Customer" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 体验JSP - 登录成功 </title>
</head>
<body>
    <% for(int i = 0; i < 10; i++){ %>
        <span>
            <%= i %>
        </span>
    <% } %>

    <%!
        public List<Customer> getCustomers() {
            List<Customer> customers = new ArrayList<>();
            for(int i = 0; i < 10; i++) {
                customers.add(new Customer("李四", i % 2 == 0 ? 1 : 0, 16 + i));
            }
            return customers;
        }
    %>

    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("lisi") && password.equals("123456")) {
    %>
            <h1> 欢迎 <%= username %> 回来, 登录成功</h1>
            <table>
                <tr>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                </tr>
            <%
                List<Customer> users = getCustomers();
                for(Customer user : users) {
            %>
                <tr>
                    <td><%= user.getName() %></td>
                    <td><%= user.getSex() == 1 ? '男' : '女' %></td>
                    <td><%= user.getAge() %></td>
                </tr>
            <%
                }
            %>
            </table>
    <%
        } else {
    %>
            <h1>
                <span style="color: red;">登录失败，</span>
                <a href="/java-web/login-jsp/login-jsp.html"> 点击这里重新登录 </a>
            </h1>
    <%
        }
    %>
</body>
</html>