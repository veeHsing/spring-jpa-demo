package com.zhangwx.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",length = 11)
    private int id;

    @Column(name = "name")
    private String name;


    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "role_user",joinColumns = {
            @JoinColumn(name = "sys_user_id",referencedColumnName = "id"),
    },inverseJoinColumns = {
            @JoinColumn(name = "sys_role_id",referencedColumnName = "rid")
    } )
    private List<Role> roles = new ArrayList<>();

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



    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name1='" + name + '\'' +
                ", roles1=" + roles +
                '}';
    }
}
