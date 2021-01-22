package com.mykolaspinkevicius.investmentcalculator.dao;

import com.mykolaspinkevicius.investmentcalculator.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class AppRoleDAO {

    @Autowired
    private EntityManager entityManager;

    public Optional<List<String>> getRoleNames(Long userId) {
        String sql = "Select ur.appRole.roleName from " + UserRole.class.getName() + "ur "
                +" where ur.appUser.userid = :userId";
        Query query = this.entityManager.createQuery(sql, String.class);
        query.setParameter("userId", userId);
        return Optional.of(query.getResultList());
    }
}
