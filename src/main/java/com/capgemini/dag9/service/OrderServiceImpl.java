package com.capgemini.dag9.service;

import com.capgemini.dag9.dao.GenericDao;
import com.capgemini.dag9.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    GenericDao genericDao;

    public OrderServiceImpl(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public boolean save(Order order) {
        genericDao.saveUsingGenerics(order);
        genericDao.saveUsingReflection(order);
        return true;
    }
}
