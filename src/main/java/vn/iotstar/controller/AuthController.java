package vn.iotstar.controller;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.iotstar.dto.*;
import vn.iotstar.service.AuthService;

@Controller
public class AuthController {
    private final AuthService auth;
    public AuthController(AuthService auth) { this.auth=auth; }

    @GetMapping("/login")
    String login() { return "auth/login"; }
}
