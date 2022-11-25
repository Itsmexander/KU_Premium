package cwp.ntkt.kupremium.controller;

import cwp.ntkt.kupremium.model.Customer;
//import cwp.ntkt.kupremium.model.User;
import cwp.ntkt.kupremium.service.CustomerDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class RegisterCustomerController {
    @Autowired
    private CustomerDetailServiceImp customerDetailsServiceImp;
    private Customer customer;

    @RequestMapping("/register_customer")
    public String getRegister(){
        return "register-customer";
    }

    @PostMapping("/register_customer")
    public String addUser(@ModelAttribute Customer customer, Model model, RedirectAttributes redirectAttrs, @ModelAttribute("repassword") String repassword){

        if (!registerCustomerCheck(customer ,repassword)){
            redirectAttrs.addFlashAttribute("error","Please correct all information");
        }
        else {
            if (!exits(customer)){
                redirectAttrs.addFlashAttribute("error","This email or Username has already exist");
            }
            else {
                if (!checkPassword(customer.getPassword(),repassword)){
                    redirectAttrs.addFlashAttribute("error","Your password is not same");
                }
                else {
                    customerDetailsServiceImp.addUser(customer);
                    return "redirect:/login";
                }
            }
        }
        return "redirect:/register-customer";
    }
    public boolean registerCustomerCheck(Customer customer, String repassword){

        if ((customer.getEmail().equals("")) || (customer.getPassword().equals("")) || (customer.getUsername().equals(""))
                || customer.getFirstName().equals("") || (repassword.equals("")) || customer.getAddress().equals("")){
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
    public boolean exits(Customer customer){
        for (int i = 0; i < customerDetailsServiceImp.getAll().size();i++){
            if (customer.getEmail().equals(customerDetailsServiceImp.getAll().get(i).getEmail()) || customer.getUsername().equals(customerDetailsServiceImp.getAll().get(i).getUsername())){
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
