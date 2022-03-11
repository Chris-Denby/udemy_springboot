package com.example.RESTWebService.model;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User
{
    private int id;
    private String name;
    private Date birthDate;


    public User(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //@Size sets minimum valid size of the string
    //@Message sets the returned error message when this is found invalid
    @Size(min = 2, message = "name should have at least 2 characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Past()
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
