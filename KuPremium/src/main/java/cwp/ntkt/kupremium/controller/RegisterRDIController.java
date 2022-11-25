package cwp.ntkt.kupremium.controller;

import cwp.ntkt.kupremium.model.RDI;
//import cwp.ntkt.kupremium.model.User;
import cwp.ntkt.kupremium.service.RDIDetailServiceImp;
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
public class RegisterRDIController {
    @Autowired
    private RDIDetailServiceImp rdiDetailServiceImp;
    private RDI rdi;

    @RequestMapping("/register_rdi")
    public String getRegister(){
        return "register-rdi";
    }

    @PostMapping("/register_rdi")
    public String addUser(@ModelAttribute RDI rdi, Model model, RedirectAttributes redirectAttrs, @ModelAttribute("repassword") String repassword){

        if (!registerRDICheck(rdi ,repassword)){
            redirectAttrs.addFlashAttribute("error","Please correct all information");
        }
        else {
            if (!exitsRDI(rdi)){
                redirectAttrs.addFlashAttribute("error","This email or Username has already exist");
            }
            else {
                if (!checkRDIPassword(rdi.getPassword(),repassword)){
                    redirectAttrs.addFlashAttribute("error","Your password is not same");
                }
                else {
                    rdiDetailServiceImp.addUser(rdi);
                    return "redirect:/login";
                }
            }
        }
        return "redirect:/register-rdi";
    }
    public boolean registerRDICheck(RDI rdi, String repassword){

        if ((rdi.getFirstName().equals("") || (rdi.getLastName().equals("") || rdi.getEmail().equals("")) || rdi.getTelNo().equals(""))
                || (rdi.getPassword().equals("")) || (rdi.getUsername().equals("")) || (repassword.equals("") || rdi.getResearcherRank().equals(""))){
            return false;
        }
        return true;
    }
    public boolean checkRDIPassword(String password, String repassword){
        if (!password.equals(repassword)){
            return false;
        }
        return true;
    }
    public boolean exitsRDI(RDI rdi){
        for (int i = 0; i < rdiDetailServiceImp.getAll().size();i++){
            if (rdi.getEmail().equals(rdiDetailServiceImp.getAll().get(i).getEmail()) || rdi.getUsername().equals(rdiDetailServiceImp.getAll().get(i).getUsername())){
                return false;
            }
        }
        return true;
    }

//    @GetMapping("/login")
//    public String getLoginPage() {
//        return "login"; // return signup.html
//    }
//
//    @GetMapping("/login_customer")
//    public String getLoginCustomerPage() {
//        return "login-customer"; // return signup.html
//    }
//
//    @GetMapping("/login_employee")
//    public String getLoginEmployeePage() {
//        return "login-employee"; // return signup.html
//    }
//
//    @GetMapping("/login_rdi")
//    public String getLoginRDIPage() {
//        return "login-rdi";
//    }
}
