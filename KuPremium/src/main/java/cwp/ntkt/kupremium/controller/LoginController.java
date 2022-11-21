package cwp.ntkt.kupremium.controller;

import cwp.ntkt.kupremium.model.ProductOwner;
import cwp.ntkt.kupremium.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class LoginController {
    @Autowired
    private UserDetailsServiceImp userDetailsServiceImp;
    private ProductOwner username;

    @RequestMapping("/register")
    public String getRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute ProductOwner productOwner, Model model, RedirectAttributes redirectAttrs, @ModelAttribute("repassword") String repassword){

        if (!registerCheck(productOwner,repassword)){
            redirectAttrs.addFlashAttribute("error","Please correct all information");
        }
        else {
//            if (!exits(productOwner)){
//                redirectAttrs.addFlashAttribute("error","This email or Username has already exist");
//            }
//            else {
                if (!checkPassword(productOwner.getPassword(),repassword)){
                    redirectAttrs.addFlashAttribute("error","Your password is not same");
                }
                else {
                    userDetailsServiceImp.addUser(productOwner);
                    return "redirect:/login";
                }
//            }
        }
        return "redirect:/register";
    }
    public boolean registerCheck(ProductOwner productOwner,String rePassword){

        if ((productOwner.getEmail().equals("")) || (productOwner.getPassword().equals("")) || (productOwner.getUsername().equals(""))
                || productOwner.getFirstName().equals("") || (rePassword.equals(""))){
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
//    public boolean exits(ProductOwner productOwner){
//        for (int i = 0; i < userDetailsServiceImp.getAll.size();i++){
//            if (productOwner.getEmail().equals(userDetailsServiceImp.getAll().get(i).getEmail()) || productOwner.getUsername().equals(userDetailsServiceImp.getAll().get(i).getUsername())){
//                return false;
//            }
//        }
//        return true;
//    }
}
