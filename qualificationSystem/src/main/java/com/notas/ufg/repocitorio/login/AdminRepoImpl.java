package com.notas.ufg.repocitorio.login;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.notas.ufg.models.Authority;

@Service
public class AdminRepoImpl implements UserDetailsService {
	
	@Autowired
    AdminRepo userRepository;
	
    @Override
     public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		
     com.notas.ufg.models.Administradores appUser = 
                 userRepository.findByUsuario(usuario).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
		
    List grantList = new ArrayList();
    for (Authority authority: appUser.getAuthority()) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
            grantList.add(grantedAuthority);
    }
		
    UserDetails user = (UserDetails) new User(appUser.getUsuario(), appUser.getClave(), grantList);
         return user;
    }
	
}
