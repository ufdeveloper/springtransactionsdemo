package com.megshan.springtransactionsdemo.controller;

import com.megshan.springtransactionsdemo.exceptions.DemoCheckedException;
import com.megshan.springtransactionsdemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

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
}
