package com.zhangwx.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid",length = 11)
    private int rid;

    @Column(name = "rname")
    private String rname;

    @ManyToMany(targetEntity = User.class,mappedBy = "roles")
//    @JoinTable(name = "role_user",joinColumns = {
//            @JoinColumn(name = "sys_role_id",referencedColumnName = "rid"),
//    },inverseJoinColumns = {
//            @JoinColumn(name = "sys_user_id",referencedColumnName = "id")
//    } )
    private List<User> users = new ArrayList<>();

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
