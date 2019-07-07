package com.ibonly.test.demo.Model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UserModel {

    public UserModel(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String name;
}
