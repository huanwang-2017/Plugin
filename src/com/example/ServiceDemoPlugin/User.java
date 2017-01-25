package com.example.ServiceDemoPlugin;

/**
 * Created by Administrator on 2017/1/4 0004.
 */
public class User {
    private String name;
    private String age;
    private String sex;
    private String des;

    public User(String name, String age, String sex, String des) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
