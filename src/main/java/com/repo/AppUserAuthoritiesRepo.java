package com.repo;

import com.model.AppUserAuthorities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserAuthoritiesRepo extends JpaRepository<AppUserAuthorities,Integer> {
    List<AppUserAuthorities> findByUsername(String s);
}
