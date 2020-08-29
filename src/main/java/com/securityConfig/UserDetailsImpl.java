package com.securityConfig;

import com.model.AppUser;
import com.model.AppUserAuthorities;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private final AppUser appUser;

    private final List<AppUserAuthorities> appUserAuthorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(appUserAuthorities==null) return Collections.emptySet();
        Set<SimpleGrantedAuthority> set=new HashSet<>();
        for(AppUserAuthorities value:appUserAuthorities) set.add(new SimpleGrantedAuthority(value.getAuthorities()));
        return set;
    }

    @Override
    public String getPassword() {
        return appUser.getPassword();
    }

    @Override
    public String getUsername() {
        return appUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
