package cwp.ntkt.kupremium.service;

import cwp.ntkt.kupremium.model.Customer;
import cwp.ntkt.kupremium.model.ProductOwner;
import cwp.ntkt.kupremium.repository.CustomerRepository;
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
public class CustomerDetailServiceImp implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RestTemplate restTemplate;

    public void addUser(Customer customer){
        String url = "http://localhost:8090/customer";
        restTemplate.postForObject(url, customer, Customer.class);
    }

    private Customer customer;
    public List<Customer> getAll(){
        String url = "http://localhost:8090/customer";
        ResponseEntity<Customer[]> response = restTemplate.getForEntity(url, Customer[].class);
        Customer[] customers = response.getBody();
        return Arrays.asList(customers);
    }

    public void setLoginUser(String name){
        for(int i = 0 ; i <this.getAll().size();i++){
            if(name.equals(this.getAll().get(i).getUsername())){
                customer = this.getAll().get(i);
            }
        }
    }
    public Customer getUser(){
        return customer;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUsername(username);

        if (customer == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(customer.getRole()));

        return new org.springframework.security.core.userdetails.User(
                customer.getUsername(), customer.getPassword(), authorities);
    }
}
