package app.mutah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.mutah.model.UserModel;
import app.mutah.service.UserService;
import app.mutah.util.Utils;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private Utils utils;

    @GetMapping(path = "")
    public List<UserModel> getUsers(@RequestParam(required = false) @Nullable Integer page,
            @RequestParam(required = false) @Nullable Integer pageSize,
            @RequestParam(required = false) @Nullable String search) {
        return userService.getUsers(utils.getValueOrDefault(page, 1), utils.getValueOrDefault(pageSize, 10),
                utils.getValueOrDefault(search, ""));
    }

}
