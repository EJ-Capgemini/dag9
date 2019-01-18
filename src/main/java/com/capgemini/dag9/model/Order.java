package com.capgemini.dag9.model;

import com.capgemini.dag9.annotation.Column;
import com.capgemini.dag9.annotation.Table;

@Table("bestelling")
public class Order implements SqlHelper{
    @Column("auto_id")
    String carId;

    @Column("werknemer_id")
    int employeeId;

    @Column("besteldatum")
    String date;

    @Override
    public String getInsertSql() {
        return "INSERT INTO bestelling(auto_id,werknemer_id,besteldatum) VALUES (" + getCarId() + "," + getEmployeeId() + "," + getDate() + ");";
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
