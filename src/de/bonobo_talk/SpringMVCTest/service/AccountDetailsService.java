package de.bonobo_talk.SpringMVCTest.service;

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

import de.bonobo_talk.SpringMVCTest.model.AccountRole;
import de.bonobo_talk.SpringMVCTest.model.User;

 

@Service("AccountDetailsService")
public class AccountDetailsService implements UserDetailsService{
 
    @Autowired
    private UserService userService;
     
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);
        System.out.println("Account : "+username);
        if(user==null){
            System.out.println("Account not found");
            throw new UsernameNotFoundException("Username not found");
        }
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
            		user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
    }
 
     
    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for(AccountRole accountRole : user.getAccountRoles()){
            System.out.println("AccountRole : "+accountRole);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+accountRole.getType()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }
}