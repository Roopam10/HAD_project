package com.example.tracker.config;

import com.example.tracker.beans.employeeDetails;
import com.example.tracker.repositories.employeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private employeeDetailsRepository edR;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        employeeDetails ed=edR.findByName(username);
        if(ed==null){
            throw new UsernameNotFoundException("No User Found!!");
        }
        CustomUserDetails customUserDetails=new CustomUserDetails(ed);
        return customUserDetails;
    }
}
