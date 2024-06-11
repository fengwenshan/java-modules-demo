package com.wenshan.todolist;

import java.util.UUID;

public class TodoListBean {

    public TodoListBean(UUID id, String username, Integer age, String link) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.like = link;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String link) {
        this.like = link;
    }

    /**
     * 添加的id
     */
    private UUID id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 爱好
     */

    private String like;


}
