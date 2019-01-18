package com.capgemini.dag9.dao;

import com.capgemini.dag9.model.SqlHelper;

public interface GenericDao {
    <T extends SqlHelper> boolean saveUsingGenerics(T t);
    <T> boolean saveUsingReflection(T t);
}
