package com.capgemini.dag9.model;

import com.capgemini.dag9.annotation.Column;
import com.capgemini.dag9.annotation.Table;

@Table("werknemer")
public class Employee implements SqlHelper{
    @Column("id")
    private int id;

    @Column("naam")
    private String name;

    @Override
    public String getInsertSql() {
        return "INSERT INTO werknemer(id,naam) VALUES (" + getId() + "," + getName() + ");";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
