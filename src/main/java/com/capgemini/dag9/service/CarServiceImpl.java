package com.capgemini.dag9.service;

import com.capgemini.dag9.dao.GenericDao;
import com.capgemini.dag9.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    GenericDao genericDao;

    public CarServiceImpl(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    public boolean save(Car car) {
        genericDao.saveUsingGenerics(car);
        genericDao.saveUsingReflection(car);
        return true;
    }
}
