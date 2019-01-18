package com.capgemini.dag9.service;

import com.capgemini.dag9.dao.GenericDao;
import com.capgemini.dag9.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    GenericDao genericDao;

    public EmployeeServiceImpl(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public boolean save(Employee employee) {
        genericDao.saveUsingReflection(employee);
        genericDao.saveUsingGenerics(employee);
        return true;
    }
}
