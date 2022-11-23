package cwp.ntkt.kupremium.controller;

import cwp.ntkt.kupremium.model.Employee;
//import cwp.ntkt.kupremium.model.User;
import cwp.ntkt.kupremium.service.EmployeeDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class RegisterEmployeeController {
    @Autowired
    private EmployeeDetailServiceImp employeeDetailServiceImp;
    private Employee employee;

    @RequestMapping("/register_employee")
    public String getRegister(){
        return "register-employee";
    }

    @PostMapping("/register_employee")
    public String addUser(@ModelAttribute Employee employee, Model model, RedirectAttributes redirectAttrs, @ModelAttribute("repassword") String repassword){

        if (!registerEmployeeCheck(employee ,repassword)){
            redirectAttrs.addFlashAttribute("error","Please correct all information");
        }
        else {
            if (!exits(employee)){
                redirectAttrs.addFlashAttribute("error","This email or Username has already exist");
            }
            else {
                if (!checkPassword(employee.getPassword(),repassword)){
                    redirectAttrs.addFlashAttribute("error","Your password is not same");
                }
                else {
                    employeeDetailServiceImp.addUser(employee);
                    return "redirect:/login";
                }
            }
        }
        return "redirect:/register-employee";
    }
    public boolean registerEmployeeCheck(Employee employee, String repassword){

        if ((employee.getFirstName().equals("") || (employee.getLastName().equals("") || employee.getEmail().equals("")) || employee.getTelNo().equals(""))
                || (employee.getPassword().equals("")) || (employee.getUsername().equals("")) || (repassword.equals("") || employee.getPosition().equals(""))){
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
    public boolean exits(Employee employee){
        for (int i = 0; i < employeeDetailServiceImp.getAll().size(); i++){
            if (employee.getEmail().equals(employeeDetailServiceImp.getAll().get(i).getEmail()) || employee.getUsername().equals(employeeDetailServiceImp.getAll().get(i).getUsername())){
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
