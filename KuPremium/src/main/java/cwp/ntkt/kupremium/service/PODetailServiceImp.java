package cwp.ntkt.kupremium.service;

import cwp.ntkt.kupremium.model.ProductOwner;
import cwp.ntkt.kupremium.model.User;
import cwp.ntkt.kupremium.repository.PORepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PODetailServiceImp implements UserDetailsService {
    @Autowired
    private PORepository poRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void addUser(ProductOwner productOwner){
        String url = "http://localhost:8090/ProductOwner";
        restTemplate.postForObject(url, productOwner, User.class);
    }

    private ProductOwner productOwner;
    public List<ProductOwner> getAll(){
        String url = "http://localhost:8090/ProductOwner";
        ResponseEntity<ProductOwner[]> response = restTemplate.getForEntity(url, ProductOwner[].class);
        ProductOwner[] productOwners = response.getBody();
        return Arrays.asList(productOwners);
    }

    public void setLoginUser(String name){
        for(int i = 0 ; i <this.getAll().size();i++){
            if(name.equals(this.getAll().get(i).getUsername())){
                productOwner = this.getAll().get(i);
            }
        }
    }
    public ProductOwner getUser(){
        return productOwner;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        ProductOwner productOwner = poRepository.findByUsername(username);

        if (productOwner == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(productOwner.getRole()));

        return new org.springframework.security.core.userdetails.User(
                productOwner.getUsername(), productOwner.getPassword(), authorities);
    }
}