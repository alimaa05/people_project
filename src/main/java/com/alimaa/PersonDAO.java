package com.alimaa;

import java.util.List;

//THIS IS A INTERFACE --> no method body just method signature

// DATA ACCESS LAYER

public interface PersonDAO {
    //Create an Interface called PersonDAO

        void savePerson(Person person);
        void deletePerson(int id);
        List<Person> getPeople();
        Person getPersonById(int id);
    }


