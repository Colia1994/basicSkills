package org.kly.javaCode.function;

import java.util.ArrayList;

/**
 * @Author konglingyao
 * @Date 2021/10/11
 */
public class User {

    private static ArrayList<User> ls = null;

    public static ArrayList<User> getUserList() {
        if (ls == null) {
            ls = new ArrayList<User>();
            ls.add(new User("001", "王", "平平", 13));
            ls.add(new User("002", "熊", "猫", 20));
            ls.add(new User("003", "王", "辉", 20));
            ls.add(new User("004", "李", "芳芳", 23));
            ls.add(new User("005", "赵", "四", 30));
        }
        return ls;
    }

    String no;
    String last_name;
    String first_name;
    int age;
    public User(String no, String last_name, String first_name, int age) {
        this.no = no;
        this.last_name = last_name;
        this.first_name = first_name;
        this.age = age;
    }
    public String toString() {
        return no + " " + last_name + " " + first_name + " " + age;
    }
}
