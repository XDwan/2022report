package com.dubbo.bookInfo.entity;

import java.io.Serializable;

/**
 * @Author: XDwan
 * @Date:2022/4/3
 * @Description:
 **/

public class Book implements Serializable {
    String name;
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
