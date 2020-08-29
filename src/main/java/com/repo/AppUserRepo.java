package com.repo;

import com.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser,Integer> {

    AppUser findByUsername(String s);
}
