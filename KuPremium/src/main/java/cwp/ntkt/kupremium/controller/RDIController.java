package cwp.ntkt.kupremium.controller;

import cwp.ntkt.kupremium.model.ProductOwner;
import cwp.ntkt.kupremium.model.RDI;
import cwp.ntkt.kupremium.service.PODetailServiceImp;
import cwp.ntkt.kupremium.service.RDIDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rdi")
public class RDIController {

    private PasswordEncoder passwordEncoder;
    @Autowired
    private RDIDetailServiceImp service;

    @GetMapping
    public String getUsers(Model model)
    {
        model.addAttribute("users", service.getAll());
        return "users";
    }

    @GetMapping("/add")
    public String getAddForm(){
        // return rings-add.html
        return "user-register";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute RDI user, Model model) {
        // พอรับเข้ามาจะเอาเข้า List
        service.addUser(user);

        return "redirect:/user";
    }
}