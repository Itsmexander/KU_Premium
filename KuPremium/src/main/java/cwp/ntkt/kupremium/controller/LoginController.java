package cwp.ntkt.kupremium.controller;

import cwp.ntkt.kupremium.model.User;
import cwp.ntkt.kupremium.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class LoginController {
    @Autowired
    private UserDetailsServiceImp userDetailsServiceImp;
    private User username;

    @RequestMapping("/register")
    public String getRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute User user, Model model, RedirectAttributes redirectAttrs, @ModelAttribute("repassword") String repassword){

        if (!registerCheck(user ,repassword)){
            redirectAttrs.addFlashAttribute("error","Please correct all information");
        }
        else {
            if (!exits(user)){
                redirectAttrs.addFlashAttribute("error","This email or Username has already exist");
            }
            else {
                if (!checkPassword(user.getPassword(),repassword)){
                    redirectAttrs.addFlashAttribute("error","Your password is not same");
                }
                else {
                    userDetailsServiceImp.addUser(user);
                    return "redirect:/login";
                }
            }
        }
        return "redirect:/register";
    }
    public boolean registerCheck(User productOwner, String rePassword){

        if ((productOwner.getEmail().equals("")) || (productOwner.getPassword().equals("")) || (productOwner.getUsername().equals(""))
                || productOwner.getFirstname().equals("") || (rePassword.equals(""))){
            return false;
        }
        return true;
    }
    public boolean checkPassword(String password, String repassword){
        if (!password.equals(repassword)){
            return false;
        }
        return true;
    }
    public boolean exits(User user){
        for (int i = 0; i < userDetailsServiceImp.getAll().size();i++){
            if (user.getEmail().equals(userDetailsServiceImp.getAll().get(i).getEmail()) || user.getUsername().equals(userDetailsServiceImp.getAll().get(i).getUsername())){
                return false;
            }
        }
        return true;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login"; // return signup.html
    }

    @GetMapping("/login_customer")
    public String getLoginCustomerPage() {
        return "login-customer"; // return signup.html
    }

    @GetMapping("/login_employee")
    public String getLoginEmployeePage() {
        return "login-employee"; // return signup.html
    }

    @GetMapping("/login_rdi")
    public String getLoginRDIPage() {
        return "login-rdi";
    }
}
