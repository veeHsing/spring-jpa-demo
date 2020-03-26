package com.zhangwx.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid")
    private int tid;

    @Column(name = "tname")
    private String tname;

//    @OneToMany(targetEntity = Student.class)
//    @JoinColumn(name = "s_tid",referencedColumnName = "tid")
    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private List<Student> list = new ArrayList<>();

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
}
