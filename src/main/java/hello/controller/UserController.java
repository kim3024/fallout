package hello.controller;

import hello.vo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping("/users")
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "apple"));
        users.add(new User(2, "banana"));
        users.add(new User(3, "kiwi"));
        return users;
    }
}
