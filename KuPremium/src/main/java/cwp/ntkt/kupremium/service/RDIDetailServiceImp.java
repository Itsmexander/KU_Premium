package cwp.ntkt.kupremium.service;

import cwp.ntkt.kupremium.model.RDI;
import cwp.ntkt.kupremium.repository.PORepository;

import cwp.ntkt.kupremium.repository.RDIRepository;
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
public class RDIDetailServiceImp implements UserDetailsService {
    @Autowired
    private RDIRepository rdiRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void addUser(RDI rdi){
        String url = "http://localhost:8090/rdi";
        restTemplate.postForObject(url, rdi, RDI.class);
    }

    private RDI rdi;
    public List<RDI> getAll(){
        String url = "http://localhost:8090/user";
        ResponseEntity<RDI[]> response = restTemplate.getForEntity(url, RDI[].class);
        RDI[] rdi = response.getBody();
        return Arrays.asList(rdi);
    }

    public void setLoginUser(String name){
        for(int i = 0 ; i <this.getAll().size();i++){
            if(name.equals(this.getAll().get(i).getUsername())){
                rdi = this.getAll().get(i);
            }
        }
    }
    public RDI getUser(){
        return rdi;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        RDI rdi = rdiRepository.findByUsername(username);

        if (rdi == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(rdi.getRole()));

        return new org.springframework.security.core.userdetails.User(
                rdi.getUsername(), rdi.getPassword(), authorities);
    }
}
