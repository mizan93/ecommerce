package com.securityConfig;

import com.model.AppUser;
import com.model.AppUserAuthorities;
import com.repo.AppUserAuthoritiesRepo;
import com.repo.AppUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AppUserRepo appUserRepo;

    private final AppUserAuthoritiesRepo appUserAuthoritiesRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AppUser appUser=appUserRepo.findByUsername(s);
        if(appUser==null) throw new UsernameNotFoundException("User Name not found");

        List<AppUserAuthorities> appUserAuthorities=appUserAuthoritiesRepo.findByUsername(s);
        return new UserDetailsImpl(appUser,appUserAuthorities);
    }
}
