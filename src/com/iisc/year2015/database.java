package com.iisc.year2015;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Dmitry on 27.11.2015.
 */
@Entity
@Table(name = "request")
public class Database {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Id
    @Column(name="id")
    private int id;

    @Column(name="login")
    private String login;

    @Column(name="pas")
    private String pas;

    @Column(name="last_name")
    private String last_name;

    @Column(name="first_name")
    private String first_name;

    public Database() {}

}
