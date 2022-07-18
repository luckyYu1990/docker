package com.example.yu;

import com.example.yu.entities.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyTest {
    @Test
    public void testListToMap() {
        List<User> users = new ArrayList<>();
        User u1 = new User();
        u1.setId(1L);
        u1.setUsername("u1");
        User u2 = new User();
        u2.setId(2L);
        u2.setUsername("u2");
        users.add(u1);
        users.add(u2);
        List<Long> ids = users.stream().map(User::getId).collect(Collectors.toList());
        System.out.println(ids);
        users.stream().collect(Collectors.toMap(User::getId, Function.identity(), (a, b) -> a));
    }
}
