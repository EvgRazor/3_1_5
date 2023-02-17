package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.UserRepositoryIml;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class RestAdminController {

    private final UserService userService;
    private final UserRepositoryIml userRepositoryIml;

    @Autowired
    public RestAdminController(UserService userService, UserRepositoryIml userRepositoryIml) {
        this.userService = userService;
        this.userRepositoryIml = userRepositoryIml;
    }

    @GetMapping()
    public List<User> getOneUser () {
        System.out.println(userRepositoryIml.findAll());
        return  userService.index();
    }




}
