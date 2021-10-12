package org.kly.javaCode.function;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @Author konglingyao
 * @Date 2021/10/11
 */
public class StreamS {

    public static void main(String[] args) {
        int i = 0;
        List<User> ls = User.getUserList();
        Stream<User> s1 = ls.stream();
        Stream<String> s2;
        try {
            s2 = s1.map(user -> {
                if (Objects.equals(user.no, "004")) {
                    throw new RuntimeException("kly");
                }
                return user.no + " " + user.last_name + " " + user.first_name;
            });

            s2.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("kly1");
        }

//        s1.forEach(System.out::println);
//        s1.sorted((user1, user2) -> user2.age - user1.age).reduce();


    }
}
