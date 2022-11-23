package cwp.ntkt.kupremium.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String getRegisterPage() {
        return "register"; // return signup.html
    }

    @GetMapping("/register_customer")
    public String getRegisterCustomerPage() {
        return "register-customer"; // return signup.html
    }

    @GetMapping("/register_employee")
    public String getRegisterEmployeePage() {
        return "register-employee"; // return signup.html
    }

    @GetMapping("/register_rdi")
    public String getRegisterRDIPage() {
        return "register-rdi"; // return signup.html
    }
}
