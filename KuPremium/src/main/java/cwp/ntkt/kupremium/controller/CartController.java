package cwp.ntkt.kupremium.controller;

import cwp.ntkt.kupremium.model.Cart;
import cwp.ntkt.kupremium.service.CartService;
import cwp.ntkt.kupremium.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductsService productsService;

    @GetMapping("")
    public String index(Model model) {
        int total = cartService.priceCalculate();
        model.addAttribute("priceCal", total);
        model.addAttribute("carts",cartService.getCart());
        return "carts";
    }

    @PostMapping("")
    public String addCart(@ModelAttribute("num") int number, @ModelAttribute("name") UUID id, Model model) {
        if (number != 0) {
            if (!exists(id, cartService.getCart(), number)) {
                cartService.addCart(id,number);
            }
        }
        model.addAttribute("carts", cartService.getCart());
        return "redirect:/cakes";
    }
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable UUID id, Model model) {
        cartService.removeCart(id);
        model.addAttribute("carts",cartService.getCart());
        return "redirect:/cart";
    }

    private boolean exists(UUID id, List<Cart> cart, int number) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getCakes().getpID().equals(id)) {
                System.out.println(cart.get(i).getQuantity());
                if (cart.get(i).getQuantity()+number<=(productsService.getOneById(id).getProductQuantity())){
                    cart.get(i).setQuantity(cart.get(i).getQuantity()+number);
                }
                else if (cart.get(i).getQuantity()+number > (productsService.getOneById(id).getProductQuantity())){
                    cart.get(i).setQuantity(productsService.getOneById(id).getProductQuantity());
                }
                return true;
            }
        }
        return false;
    }
}
