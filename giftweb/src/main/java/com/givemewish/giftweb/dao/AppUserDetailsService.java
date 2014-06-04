package com.givemewish.giftweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.givemewish.giftweb.model.User;

@Service
@Transactional(readOnly=true)
public class AppUserDetailsService implements UserDetailsService {
     
    @Autowired
    private UserDAO userDAO;    
 
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
         
        User domainUser = userDAO.getUserByName(login);
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        org.springframework.security.core.userdetails.User user = 
                new org.springframework.security.core.userdetails.User(String.valueOf(domainUser.getId()), 
                domainUser.getPasswd(), authList);
        return user;
    }
}
     
