package cwp.ntkt.kupremium.controller;

import cwp.ntkt.kupremium.model.ProductOwner;
//import cwp.ntkt.kupremium.model.User;
import cwp.ntkt.kupremium.service.PODetailServiceImp;
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
public class RegisterPOController {
    @Autowired
    private PODetailServiceImp poDetailServiceImp;
    private ProductOwner productOwner;

    @RequestMapping("/register")
    public String getRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute ProductOwner productOwner, Model model, RedirectAttributes redirectAttrs, @ModelAttribute("repassword") String repassword){

        if (!registerPOCheck(productOwner ,repassword)){
            redirectAttrs.addFlashAttribute("error","Please correct all information");
        }
        else {
            if (!exits(productOwner)){
                redirectAttrs.addFlashAttribute("error","This email or Username has already exist");
            }
            else {
                if (!checkPassword(productOwner.getPassword(),repassword)){
                    redirectAttrs.addFlashAttribute("error","Your password is not same");
                }
                else {
                    poDetailServiceImp.addUser(productOwner);
                    return "redirect:/login";
                }
            }
        }
        return "redirect:/register";
    }
    public boolean registerPOCheck(ProductOwner productOwner, String repassword){

        if ((productOwner.getFirstName().equals("") || (productOwner.getLastName().equals("") || productOwner.getEmail().equals("")) || productOwner.getTelNo().equals("")) || (productOwner.getPassword().equals("")) || (productOwner.getUsername().equals(""))
                || (repassword.equals("") || productOwner.getCompanyName().equals("") || productOwner.getCompanyAddress().equals(""))){
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
    public boolean exits(ProductOwner productOwner){
        for (int i = 0; i < poDetailServiceImp.getAll().size(); i++){
            if (productOwner.getEmail().equals(poDetailServiceImp.getAll().get(i).getEmail()) || productOwner.getUsername().equals(poDetailServiceImp.getAll().get(i).getUsername())){
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
