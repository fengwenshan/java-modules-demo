package com.wenshan.todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TodoListStore {
    // 先定义一个数组
    private static final List<TodoListBean> list = new ArrayList<TodoListBean>();

    static {
        // list.add(new TodoListBean(UUID.randomUUID(), "lisi", 18, "1,2,3"));
    }

    public static void add(TodoListBean todo) {
        list.add(todo);
    }

    /**
     * java中 static静态方法的作用： 静态方法只能访问静态变量，不能访问非静态变量。
     * java中 static静态变量的作用： 静态变量属于类，所有对象共享，所有对象都可以访问。
     * java中 static静态块的作用： 静态块在类加载的时候执行，只执行一次。
     * java中 static final 常量的作用： 常量属于类，所有对象共享，所有对象都可以访问。
     *
     *
     * @return
     */
    public static List<TodoListBean> getTodoList() { return list; }

}
