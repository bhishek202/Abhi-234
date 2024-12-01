package com.airbnb.Controller;

import com.airbnb.EmployeeRepository;
import com.airbnb.Entity.Employee;
import com.airbnb.Payload.LoginDto;
import com.airbnb.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService sero;


    @PostMapping("/add")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        Optional<Employee> opName = employeeRepository.findByName(employee.getName());
        if (opName.isPresent()) {
            return new ResponseEntity<>("Name is Exists", HttpStatus.OK);

        }
        Optional<Employee> opEmail = employeeRepository.findByEmail(employee.getEmail());
        if (opEmail.isPresent()) {
            return new ResponseEntity<>("Email is Exists", HttpStatus.OK);
        }


        Optional<Employee> opMobile = employeeRepository.findByMobile(employee.getMobile());
        if(opMobile.isPresent()){
            return new ResponseEntity<>("mobile number exist" , HttpStatus.OK);
        }


        Optional<Employee> opPassword = employeeRepository.findByPassword(employee.getPassword());
        if (opPassword.isPresent()) {
            return new ResponseEntity<>("password is Exists", HttpStatus.OK);

        }

        employee.setPassword(BCrypt.hashpw(employee.getPassword(),BCrypt.gensalt(10)));

       Employee employee1= employeeRepository.save(employee);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public String Login(@RequestBody LoginDto loginDto)
    {
        boolean val=sero.verifyLogin(loginDto);
        if(val){
            return "Logged";
        }else{
            return "Invelid name/password";
        }
    }



}
