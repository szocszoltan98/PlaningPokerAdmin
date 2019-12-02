package com.example.planingpokeradmin;

public class Admin {
    String admiId;
    String adminName;
    String adminGroup;

    public Admin(){//ures konstruktor

    }

    //konstruktor
    public Admin(String admiId, String adminName,String adminGroup) {
        this.admiId = admiId;
        this.adminName = adminName;
        this.adminGroup=adminGroup;
    }

    //getter metodusok
    public String getAdmiId() {
        return admiId;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminGroup() {
        return adminGroup;
    }
}
