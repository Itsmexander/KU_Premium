package cwp.ntkt.kupremium.service;

import cwp.ntkt.kupremium.model.Employee;
import cwp.ntkt.kupremium.model.ProductOwner;
import cwp.ntkt.kupremium.repository.EmployeeRepository;
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
public class EmployeeDetailServiceImp implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void addUser(Employee employee){
        String url = "http://localhost:8090/employee";
        restTemplate.postForObject(url, employee, Employee.class);
    }

    private Employee employee;
    public List<Employee> getAll(){
        String url = "http://localhost:8090/employee";
        ResponseEntity<Employee[]> response = restTemplate.getForEntity(url, Employee[].class);
        Employee[] employees = response.getBody();
        return Arrays.asList(employees);
    }

    public void setLoginUser(String name){
        for(int i = 0 ; i <this.getAll().size();i++){
            if(name.equals(this.getAll().get(i).getUsername())){
                employee = this.getAll().get(i);
            }
        }
    }
    public Employee getUser(){
        return employee;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);

        if (employee == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(employee.getRole()));

        return new org.springframework.security.core.userdetails.User(
                employee.getUsername(), employee.getPassword(), authorities);
    }
}
