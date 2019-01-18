package com.capgemini.dag9.dao;

import com.capgemini.dag9.model.SqlHelper;
import com.capgemini.dag9.utility.QueryBuilderUtil;
import com.capgemini.dag9.utility.ReflectionUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenericDaoImpl implements GenericDao{
    public <T extends SqlHelper> boolean saveUsingGenerics(T t) {
        System.out.println("SQL via methode saveUsingGenerics -> " + t.getInsertSql());
        return true;
    }

    public <T> boolean saveUsingReflection(T t){
        Class c = t.getClass();

        String table = ReflectionUtil.getInstance().getClassValue(c); //tabelnaam
        List<String> fields = ReflectionUtil.getInstance().getFieldNames(c); //class fields
        List<String> columnValues = ReflectionUtil.getInstance().getFieldColumnValue(c); //column values van class fields
        List<String> values = ReflectionUtil.getInstance().getFieldValues(t, fields); //waarde van class field

        if(fields.size() != columnValues.size() | fields.size() != values.size()){
            System.out.println("Hier is iets fout gegaan. Aantal velden en inhoud komen niet overeen.");
            return false;
        } else {
            String sql = QueryBuilderUtil.getInstance().buildInsertQuery(table, columnValues, values);
            System.out.println("SQL via methode saveUsingReflection -> " + sql);
            return true;
        }
    }
}
