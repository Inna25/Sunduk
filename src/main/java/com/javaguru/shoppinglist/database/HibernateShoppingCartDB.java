package com.javaguru.shoppinglist.database;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public class HibernateShoppingCartDB {
    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateShoppingCartDB(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long createShoppingCart(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().save(shoppingCart);
        return shoppingCart.getId();
    }

    public Optional<ShoppingCart> getByID(Long id) {
        ShoppingCart shoppingCart = (ShoppingCart) sessionFactory.getCurrentSession().createCriteria(ShoppingCart.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(shoppingCart);
    }

    public void delete(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().delete(shoppingCart);
    }

    public void update(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().saveOrUpdate(shoppingCart);
    }
}
