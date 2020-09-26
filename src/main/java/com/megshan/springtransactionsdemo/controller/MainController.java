package com.megshan.springtransactionsdemo.controller;

import com.megshan.springtransactionsdemo.DemoCheckedException;
import com.megshan.springtransactionsdemo.data.UserRepository;
import com.megshan.springtransactionsdemo.domain.User;
import com.megshan.springtransactionsdemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DemoService demoService;

    @PostMapping(path="/add")
    @ResponseBody
    public String addNewUser(@RequestParam String name, @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @PostMapping(path="/noRollback")
    @ResponseBody
    public String noRollback() {
        demoService.noRollback();
        return "Saved";
    }

    @PostMapping(path="/rollbackOnRuntimeException")
    @ResponseBody
    public String rollbackOnRuntimeException() {
        demoService.rollbackOnRuntimeException();
        return "Saved";
    }

    @PostMapping(path="/noRollbackOnCheckedException")
    @ResponseBody
    public String noRollbackOnCheckedException() throws DemoCheckedException {
        demoService.noRollbackOnCheckedException();
        return "Saved";
    }

    @GetMapping(path="/all")
    @ResponseBody
    public Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
