package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int id;
    private String name;
    private String qulaification;
    private List<Integer> s_id;
    public Teacher()
    {}


    public Teacher(int id,String name,String qulaification,List<Integer> sub_id)
    {
         this.id=id;
         this.name=name;
         this.qulaification=qulaification;
         this.sub_ids=sub_id;

    }

    public List<Integer> getSub_ids() {
        return sub_ids;
    }

   /* @Transient
    List<Teacher> tecList;

    public List<Teacher> getTecList() {
        return tecList;
    }

    public void setTecList(List<Teacher> tecList) {
        this.tecList = tecList;
    }*/





    public void setSub_ids(List<Integer> sub_ids) {
        this.sub_ids = sub_ids;
    }

    public List<Integer> sub_ids =new ArrayList<>();

    public List<Integer> getS_id() {
        return s_id;
    }

    public void setS_id(List<Integer> s_id) {
        this.s_id = s_id;
    }

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

    public String getQulaification() {
        return qulaification;
    }

    public void setQulaification(String qulaification) {
        this.qulaification = qulaification;
    }


}
