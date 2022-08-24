package com.example.demo.models;

// Annotations


import org.springframework.data.annotation.Transient;
import java.util.ArrayList;
import java.util.List;


public class Student {
    private int id;
    private String Name;
    private int age, marks;
    private String Comp;
    private List<Integer> sub_ids=new ArrayList<>();
    private List<Integer> t_id;
    @Transient
    List<Teacher> tecList= new ArrayList<>();
    public List<Integer> getSub_ids() {
        return sub_ids;
    }

    public void setSub_ids(List<Integer> sub_ids) {
        this.sub_ids = sub_ids;
    }

    public List<Teacher> getTecList() {
        return tecList;
    }

    public void setTecList(List<Teacher> tecList) {
        this.tecList = tecList;
    }

    public List<Integer> getT_id() {
        return t_id;
    }

    public void setT_id(List<Integer> t_id) {
        this.t_id = t_id;
    }




    //constructor
   public Student()
   {}

    public Student( int id,String name,int Age,int Marks, String Company)
    {
        this.id =id;
        this.Name=name;
        this.age=Age;
        this.marks=Marks;
        this.Comp=Company;

    }
    public Student( int id,String name,int Age,int Marks, String Company,List<Integer> su,List<Integer> tec)
    {
        this.id =id;
        this.Name=name;
        this.age=Age;
        this.marks=Marks;
        this.Comp=Company;
        this.sub_ids=su;

    }

    // Setter
    public void setId(int id)
    {
        this.id =id;
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public void setMarks(int marks)
    {
        this.marks=marks;
    }
    public void setName(String name)
    {
        this.Name=name;
    }
    public void setCompany(String company)
    {
        this.Comp=company;
    }
    // Getters

    public int getId() {
        return id;
    }
    public String getName() {
        return Name;
    }
    public int getAge() {
        return age;
    }
    public int getMarks() {
        return marks;
    }

    public String getCompany() {
        return Comp;
    }

}
