package com.mykolaspinkevicius.investmentcalculator.services;

import com.mykolaspinkevicius.investmentcalculator.dao.AppRoleDAO;
import com.mykolaspinkevicius.investmentcalculator.dao.AppUserDAO;
import com.mykolaspinkevicius.investmentcalculator.entities.AppUser;
import com.mykolaspinkevicius.investmentcalculator.exceptions.NoUserFoundException;
import com.mykolaspinkevicius.investmentcalculator.exceptions.UserIdNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserDAO appUserDAO;

    @Autowired
    private AppRoleDAO appRoleDAO;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = this.appUserDAO.findUserAccount(userName).orElseThrow(() -> new NoUserFoundException("User was not found"));
        List<String> roleNames = this.appRoleDAO.getRoleNames(appUser.getUserId()).orElseThrow(() -> new UserIdNotFound("User ID was not found even tho user was found"));
        return null;
    }
}
