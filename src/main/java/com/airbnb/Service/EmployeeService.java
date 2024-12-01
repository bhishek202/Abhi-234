package com.airbnb.Service;

import com.airbnb.EmployeeRepository;
import com.airbnb.Entity.Employee;
import com.airbnb.Payload.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;


    public boolean verifyLogin(LoginDto loginDto){

        Optional< Employee> opEmployee=repo.findByName(loginDto.getName());
        if(opEmployee.isPresent()){

            Employee employee=opEmployee.get();
            if(BCrypt.checkpw(loginDto.getPassword(),employee.getPassword())){

                return true;

            }else{
                return false;
            }
        }
        return  false;
    }







}
