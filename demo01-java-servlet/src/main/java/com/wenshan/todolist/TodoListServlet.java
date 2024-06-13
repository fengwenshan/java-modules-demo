package com.wenshan.todolist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/todo-list")
public class TodoListServlet extends HttpServlet {


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // UUID randomUUID = UUID.randomUUID();
        // String username = req.getParameter("username");
        // String age = req.getParameter("age");
        // String like = req.getParameter("like");

        // req.setAttribute("info", new TodoListBean(randomUUID, username, Integer.valueOf(age), like));
        // 将客户数据存储到req中
        // req.setAttribute("userData", TodoListStore.getTodoList());
        // // 转发到list.jsp中处理
        // req.getRequestDispatcher("/todo-list/list.jsp").forward(req, res);
    }
}
