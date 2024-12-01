package com.airbnb;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class A {


    public static void main(String[] args) {

    // that code use in the first  way logic encode
       // PasswordEncoder e= new BCryptPasswordEncoder();
       // System.out.println(e.encode("testing"));

        // that is the second method use logic in encode
        String encoded=BCrypt.hashpw("testing",BCrypt.gensalt());
        System.out.println(encoded);
    }
}
