package com.circle.circle.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/circulus_casa")
public class PageController {

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/users")
    public String usersPage() {
        return "users";
    }

    @GetMapping("/circles")
    public String circlesPage() {
        return "circles";
    }

    @GetMapping("/nodes")
    public String nodesPage() {
        return "nodes";
    }

    @GetMapping("/join_requests")
    public String joinRequestsPage() {
        return "join_requests";
    }
}