package com.csquare.ums.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user", schema = "public")

public class UserMaster implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private long userid;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    public long getUserid() {

        return userid;
    }

    public void setUserid(long userid) {

        this.userid = userid;
    }

    public String getUsername() {

        return userName;
    }

    public void setUsername(String username) {

        this.userName = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

}
