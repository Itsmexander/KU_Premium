package cwp.ntkt.kupremium.service;

import cwp.ntkt.kupremium.model.ProductOwner;
import cwp.ntkt.kupremium.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import cwp.ntkt.kupremium.model.User;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void addUser(ProductOwner productOwner){
        String url = "http://localhost:8090/user";
        restTemplate.postForObject(url, productOwner, ProductOwner.class);
    }

    private User user;
    public List<User> getAll(){
        String url = "http://localhost:8090/user";
        ResponseEntity<User[]> response = restTemplate.getForEntity(url, User[].class);
        User[] users = response.getBody();
        return Arrays.asList(users);
    }

    public void setLoginUser(String name){
        for(int i = 0 ; i <this.getAll().size();i++){
            if(name.equals(this.getAll().get(i).getUsername())){
                user = this.getAll().get(i);
            }
        }
    }
    public User getUser(){
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), authorities);
    }
}