package com.alraisent.alraisitassets.security;

import com.alraisent.alraisitassets.entity.User;
import com.alraisent.alraisitassets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findUserByUsername(s);

        if(user == null) {
            throw new UsernameNotFoundException("Could not find username");
        }
        return new UserPrincipalDetails(user);
    }
}
