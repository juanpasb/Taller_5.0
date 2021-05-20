package edu.unbosque.JPATutorial.servlets.pojos;

public class CustomerPOJO {

    private String firts_name;

    private String last_name;

    private String gender;

    private Integer age;

    public CustomerPOJO(){}

    public CustomerPOJO(String firts_name, String last_name, String gender, Integer age) {
        this.firts_name = firts_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
    }

    public String getFirts_name() {
        return firts_name;
    }

    public void setFirts_name(String firts_name) {
        this.firts_name = firts_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
