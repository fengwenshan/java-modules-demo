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
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        String like = req.getParameter("like");

        TodoListBean bean = new TodoListBean();

        bean.setUsername(username);
        bean.setAge(Integer.valueOf(age));
        bean.setLike(like);
        // 添加到store中
        TodoListStore.add(bean);


        // 转发到 TodoListService 中处理
        req.getRequestDispatcher("/todo-list/list").forward(req, res);
    }
}
