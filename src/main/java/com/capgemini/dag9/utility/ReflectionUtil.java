package com.capgemini.dag9.utility;

import com.capgemini.dag9.annotation.Column;
import com.capgemini.dag9.annotation.Table;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionUtil {
    private static ReflectionUtil reflectionUtil;

    private ReflectionUtil(){ }

    public static synchronized ReflectionUtil getInstance( ) {
        if (reflectionUtil == null)
            reflectionUtil = new ReflectionUtil();
        return reflectionUtil;
    }

    /*
        Voor een class de value van de Table column ophalen, mits deze bestaat.
     */
    public String getClassValue(Class c){
        if (c.isAnnotationPresent(Table.class)) {
            Table t = (Table) c.getAnnotation(Table.class);
            return t.value();
        } else {
            return null;
        }
    }

    /*
        Voor een class alle velden ophalen met de Column annotatie.
     */
    public List<String> getFieldNames(Class c) {
        Field[] declaredFields = c.getDeclaredFields();
        List<String> fieldNames = Arrays.stream(declaredFields)
                .filter(field -> field.isAnnotationPresent(Column.class))
            .map(x -> x.getName())
            .collect(Collectors.toList());

        return fieldNames;
}

    /*
        Voor een class de value van de Column annotatie ophalen voor elke veld die hier gebruik van maakt.
        Hiermee wordt opgehaald hoe de velden genoemd worden in de database.
     */
    public List<String> getFieldColumnValue(Class c){
        Field[] declaredFields = c.getDeclaredFields();
        List<String> fieldColumnValues = Arrays.stream(declaredFields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .map(x -> x.getAnnotation(Column.class).value())
                .collect(Collectors.toList());

        return fieldColumnValues;
    }

    /*
        Roept de callGetter methode aan voor een lijst van velden van een object.
        Voor het huidige doel zouden deze 2 methodes ook samengevoegd kunnen worden.
     */
    public List<String> getFieldValues(Object obj, List<String> fields){
        List<String> fieldValues = new ArrayList<>();
        for (String field : fields) {
            fieldValues.add(callGetter(obj, field));
        }
        return fieldValues;
    }

    /*
        Value van 1 specifiek veld van een object ophalen via de get methode.
     */
    private String callGetter(Object obj, String fieldName) {
        PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(fieldName, obj.getClass());
            return "" + pd.getReadMethod().invoke(obj);
        } catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
