package com.azhimkulov.azamat.svetofor.entity.phone_number_model;

/**
 * Created by azamat  on 09.04.18.
 */

public class PhoneNumberModel {
    private String number;
    private int id;
    private String city;

    public PhoneNumberModel() {
    }

    public PhoneNumberModel(String number, int id, String city) {
        this.number = number;
        this.id = id;
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
