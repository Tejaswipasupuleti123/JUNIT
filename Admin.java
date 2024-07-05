package com.example.hrmanagementtejaswi;

public class Admin {

    private int id;
    private String name;
    private String password;
    private String city;

    public Admin(int id, String name, String password, String city) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.city = city;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
