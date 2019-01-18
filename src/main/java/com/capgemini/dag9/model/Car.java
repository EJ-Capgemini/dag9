package com.capgemini.dag9.model;

import com.capgemini.dag9.annotation.Column;
import com.capgemini.dag9.annotation.Table;

@Table("auto")
public class Car implements SqlHelper{
    @Column("id")
    String licensePlate;

    @Column("merk")
    String brand;

    @Override
    public String getInsertSql() {
        return "INSERT INTO auto(id,merk) VALUES (" + getLicensePlate() + "," + getBrand() + ");";
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
