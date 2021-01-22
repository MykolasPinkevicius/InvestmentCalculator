package com.mykolaspinkevicius.investmentcalculator.dao;

import com.mykolaspinkevicius.investmentcalculator.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public class AppUserDAO {

    @Autowired
    private EntityManager entityManager;

    public Optional<AppUser> findUserAccount(String userName) {
        try{
            String sql = "Select e from " + AppUser.class.getName() + "e"
                    + "Where e.userName = :userName";
            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName", userName);
            return Optional.of((AppUser) query.getSingleResult());
        } catch(NoResultException e) {
            return Optional.empty();
        }
    }
}
