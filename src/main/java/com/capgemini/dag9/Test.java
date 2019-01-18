package com.capgemini.dag9;

import com.capgemini.dag9.annotation.Table;
import com.capgemini.dag9.model.Employee;
import com.capgemini.dag9.utility.ReflectionUtil;

import java.util.Date;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        Object employee = new Employee();
        for (String fieldName : ReflectionUtil.getInstance().getFieldNames(employee.getClass())) {
            System.out.println(fieldName);
        }

        System.out.println(ReflectionUtil.getInstance().getClassValue(Employee.class));

        //Tests n.a.v. GenericsFAQ
        LinkedList list = new LinkedList();
        list.add("abc");       // fine
        list.add(new Date());  // fine as well
    }
}
