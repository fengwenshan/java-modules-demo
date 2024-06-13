package com.wenshan.todolist;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/todo-list/list")
public class TodoListService {
    public TodoListService() {}

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<TodoListBean> todoList = TodoListStore.getTodoList();

        // 将客户数据存储到request中，用于jsp页面访问
        req.setAttribute("todoList", todoList);

        // 转发到list.jsp页面进行数据展示
        req.getRequestDispatcher("/todo-list/list.jsp").forward(req, res);
    }
}
