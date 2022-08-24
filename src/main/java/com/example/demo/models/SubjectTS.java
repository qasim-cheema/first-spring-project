package com.example.demo.models;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class SubjectTS {
    private int subId;
    private String subName;
    private List<Student> sList=new ArrayList<>();
    private List<Teacher> tList =new ArrayList<>();

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public List<Student> getsList() {
        return sList;
    }

    public void setsList(List<Student> sList) {
        this.sList = sList;
    }

    public List<Teacher> gettList() {
        return tList;
    }

    public void settList(List<Teacher> tList) {
        this.tList = tList;
    }




}
