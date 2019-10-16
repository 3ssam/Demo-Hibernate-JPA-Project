package com.essam.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Labtop {
    @Id
    private int lid;
    private String lname;

    @ManyToMany
    private List<Student> student=new ArrayList<Student>();

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public Labtop() {
    }

    public Labtop(int lid, String lname) {
        this.lid = lid;
        this.lname = lname;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Labtop{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                '}';
    }
}
