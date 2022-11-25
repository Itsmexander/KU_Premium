//package cwp.ntkt.kupremium.controller;
//
//import cwp.ntkt.kupremium.model.ProductOwner;
//import cwp.ntkt.kupremium.service.PODetailServiceImp;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@Controller
//@RequestMapping("")
//public class POLoginController {
//    @Autowired
//    private PODetailServiceImp poDetailServiceImp;
//    private ProductOwner productOwner;
//
//    @RequestMapping("/register")
//    public String getRegister(){
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String addUser(@ModelAttribute ProductOwner productOwner, Model model, RedirectAttributes redirectAttrs, @ModelAttribute("repassword") String repassword){
//
//        if (!registerCheck(productOwner ,repassword)){
//            redirectAttrs.addFlashAttribute("error","Please correct all information");
//        }
//        else {
//            if (!exits(productOwner)){
//                redirectAttrs.addFlashAttribute("error","This email or Username has already exist");
//            }
//            else {
//                if (!checkPassword(productOwner.getPassword(),repassword)){
//                    redirectAttrs.addFlashAttribute("error","Your password is not same");
//                }
//                else {
//                    poDetailServiceImp.addUser(productOwner);
//                    return "redirect:/login";
//                }
//            }
//        }
//        return "redirect:/register";
//    }
//    public boolean registerCheck(ProductOwner productOwner, String rePassword){
//
//        if ((productOwner.getEmail().equals("")) || (productOwner.getPassword().equals("")) || (productOwner.getUsername().equals(""))
//                || productOwner.getFirstName().equals("") || (rePassword.equals(""))){
//            return false;
//        }
//        return true;
//    }
//    public boolean checkPassword(String password, String rePassword){
//        if (!password.equals(rePassword)){
//            return false;
//        }
//        return true;
//    }
//    public boolean exits(ProductOwner user){
//        for (int i = 0; i < poDetailServiceImp.getAll().size();i++){
//            if (productOwner.getEmail().equals(poDetailServiceImp.getAll().get(i).getEmail()) || productOwner.getUsername().equals(poDetailServiceImp.getAll().get(i).getUsername())){
//                return false;
//            }
//        }
//        return true;
//    }
//}
