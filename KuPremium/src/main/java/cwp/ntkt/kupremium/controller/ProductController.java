package cwp.ntkt.kupremium.controller;

import cwp.ntkt.kupremium.dto.SignupDto;
import cwp.ntkt.kupremium.model.ProductInfo;
import cwp.ntkt.kupremium.service.PODetailServiceImp;
import cwp.ntkt.kupremium.service.ProductsService;
import cwp.ntkt.kupremium.service.RDIDetailServiceImp;
import cwp.ntkt.kupremium.service.UserDetailsServiceImp;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductsService productsService;
    @Autowired
    private PODetailServiceImp poDetailServiceImp;
    @Autowired
    private RDIDetailServiceImp rdiDetailServiceImp;


    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable UUID id, Model model) {
        ProductInfo products = productsService.getOneById(id);
        model.addAttribute("products", products);
        return "cakes-edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute ProductInfo products, Model model) {
        productsService.update(products);
        return "redirect:/cakes";
    }

    @GetMapping("")
    public String getCakes(Model model, Authentication authentication)
    {
        System.out.println("1111111111111111111111111111111111111111111");
        poDetailServiceImp.setLoginUser(authentication.getName()); //***
        System.out.println("2222222222222222222222222222222222222222222");
        model.addAttribute("products", productsService.getAll());
        System.out.println("3333333333333333333333333333333333333333+33");
        return "cakes";
    }
//    @GetMapping
//    public String getCakes(Model model, Authentication authentication)
//    {
//        rdiDetailServiceImp.setLoginUser(authentication.getName()); //***
//        model.addAttribute("products", productsService.getAll());
//        return "cakes";
//    }

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

    @GetMapping("/certification")
    public String getCertificatePage() {
        return "certificate-add"; // return signup.html
    }

    @GetMapping("/related_Research")
    public String getRelatedResearchPage() {
        return "related-Research"; // return signup.html
    }

    @GetMapping("/product_story")
    public String getProductStoryPage() {
        return "product-story"; // return signup.html
    }

    @GetMapping("/food")
    public String getFoodPage() {
        return "food-traceability"; // return signup.html
    }

    @GetMapping("/audio")
    public String getAudioPage() {
        return "audio"; // return signup.html
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

    @GetMapping("/data_add")
    public String getDataAddPage() {
        return "data-add"; // return signup.html
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
