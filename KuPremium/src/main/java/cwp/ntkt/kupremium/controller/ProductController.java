package cwp.ntkt.kupremium.controller;

import cwp.ntkt.kupremium.dto.SignupDto;
import cwp.ntkt.kupremium.model.ProductInfo;
import cwp.ntkt.kupremium.service.ProductsService;
import cwp.ntkt.kupremium.service.UserDetailsServiceImp;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {
        @Autowired
        private ProductsService productsService;
        @Autowired
        private UserDetailsServiceImp userDetailsServiceImp;


        @GetMapping("/edit/{id}")
        public String getEditForm(@PathVariable UUID id, Model model) {
            ProductInfo products = productsService.getOneById(id);
            model.addAttribute("cakes", products);
            return "cakes-edit";
        }

        @PostMapping("/edit")
        public String edit(@ModelAttribute ProductInfo products, Model model) {
            productsService.update(products);
            return "redirect:/cakes";
        }

        @GetMapping
        public String getCakes(Model model, Authentication authentication)
        {
            userDetailsServiceImp.setLoginUser(authentication.getDeclaringClass().getName()); //***
            model.addAttribute("cakes", productsService.getAll());
            return "cakes";
        }

        @GetMapping("/add")
        public String getAddForm(){
            // return rings-add.html
            return "cakes-add";
        }

        @PostMapping("/add")
        public String addCakes(@ModelAttribute ProductInfo products, Model model) {
            // พอรับเข้ามาจะเอาเข้า List
            productsService.addCakes(products);

            return "redirect:/cakes";
        }

        @GetMapping("/check356")
        public String getFDA356Page() {
            return "fda-check356"; // return signup.html
        }

        @GetMapping("/check414")
        public String getFDA414Page() {
            return "fda-check414"; // return signup.html
        }

        @GetMapping("/check416")
        public String getFDA416Page() {
            return "fda-check416"; // return signup.html
        }

        @GetMapping("/check418")
        public String getFDA418Page() {
            return "fda-check418"; // return signup.html
        }
        @GetMapping("/inspection")
        public String getInspectionPage() {
            return "inspection-data"; // return signup.html
        }
        @GetMapping("/audit_results")
        public String getAuditPage() {
            return "audit-results"; // return signup.html
        }

//        @GetMapping("/register_customer")
//        public String getRegisterCustomerPage() {
//            return "register-customer"; // return signup.html
//        }
//
//        @GetMapping("/register_employee")
//        public String getRegisterEmployeePage() {
//            return "register-employee"; // return signup.html
//        }
//
//        @GetMapping("/register_rdi")
//        public String getRegisterRDIPage() {
//            return "register-rdi"; // return signup.html
//        }
}
