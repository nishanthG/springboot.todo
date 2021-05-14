package com.ng.webservice.restfulwebservices.todo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Todos implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String description;
    private Date date;
    private boolean isDone;
    
    public Todos() {}

    public Todos(Long id, String username, String description, Date date, boolean isDone) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.date = date;
        this.isDone = isDone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public boolean isDone() {
        return isDone;
    }
    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    
}
