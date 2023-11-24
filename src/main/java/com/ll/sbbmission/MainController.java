package com.ll.sbbmission;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/sbb")
    public String index() {
        return "index";
    }
}
