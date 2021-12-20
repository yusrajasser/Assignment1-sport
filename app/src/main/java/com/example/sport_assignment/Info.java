package com.example.sport_assignment;

public class Info {
    private String name;
    private String email;
    private String phone;
    private String gender;

    public Info(){

    }

    public Info(String name,String email,String phone, String gender){
        this.name= name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
