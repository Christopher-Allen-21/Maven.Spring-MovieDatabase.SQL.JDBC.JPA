package io.zipcoder.persistenceapp.models;

import java.util.Date;

public class Person {

    private Integer id;
    private String firstName;
    private String lastName;
    private String mobile;
    private Date birthday;
    private Integer homeId;

    public Person(Integer id, String firstName, String lastName, String mobile, Date birthday, Integer homeId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.birthday = birthday;
        this.homeId = homeId;
    }

    public Person(){

    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
    }
}
