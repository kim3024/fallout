package hello;

import hello.vo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private  static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "user", defaultValue = "world") String user){
        Greeting data = new Greeting(counter.incrementAndGet(), String.format(template, user));
        return  data;
    }

    @RequestMapping("/wawa")
    public Map<String, Object> getUsers(@RequestParam(value = "user", defaultValue = "world") String user){
        Map<String, Object> mapper = new HashMap<>();
        Greeting data = new Greeting(counter.incrementAndGet(), String.format(template, user));
        mapper.put("data", data);
        List<User> users = new ArrayList<>();
        users.add(new User(1, "apple"));
        users.add(new User(2, "banana"));
        users.add(new User(3, "kiwi"));
        mapper.put("users", users);
        return  mapper;
    }
}
