package user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import user.model.User;
import user.services.UserServices;
import user.vo.ResponseTemplateVo;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserServices userServices;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        log.info("Using saveUser method of UserController");
        return userServices.saveUser(user);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseTemplateVo getUserById(@PathVariable("id") Long userId) {
        log.info("Using getUserById method of UserController");
        return userServices.getUser(userId);
    }

    @GetMapping("/userList")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        log.info("Using getAllUsers method of UserController");
        return userServices.getAllUsers();
    }

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String Hello() {
        return "Hello World!";
    }
}