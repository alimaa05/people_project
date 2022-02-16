package com.alimaa;

import java.util.Objects;

//POJO

public class Person {

    // Create class called Person with following properties and dd Constructor, Getters,
    // Setters and ToString methods
    private Integer id;
    private String name;
    private Integer age;
    //INTEGER RATHER THAN INT BEC INT DOESN'T EXCEPT OR RETURN NULL, IT WOULD RETURN 0 -
    // WE WANT TO ACCEPT AN ARGUMENT WHERE THE RESPONSE WOULD RETURN NULL BEC WE DON'T WANT IT TO RETURN A NUMBER I.E. 0


    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
