package com.example.khokan.friendsbirthday;

/**
 * Created by USER on 8/25/2018.
 */

public class DataTemp {

    private int id;
    private String name;
    private String bdate;

    public DataTemp(String n,String bd){
        name=n;
        bdate=bd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getBdate() {
        return bdate;
    }
}

