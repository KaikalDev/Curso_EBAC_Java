package kaique.luan.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GlobalController {

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }
}
