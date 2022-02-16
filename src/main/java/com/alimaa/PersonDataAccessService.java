package com.alimaa;

import java.util.ArrayList;
import java.util.List;

// DATA ACCESS LAYER


//Create one implementation for PersonDAO called PersonDataAccessService.
//Note that PersonDataAccessService should implement all methods and save,
//delete, and get data from a file or a static list.

// PersonDataAccessService IMPLEMENTS THE PersonDAO service (which is an INTERFACE)


public class PersonDataAccessService implements PersonDAO{

    // INITIALISING MY LIST METHOD - WHICH WILL RETURN A PERSON - LIST IS CALLED 'personList'
    public List<Person> personList = new ArrayList<>();


    @Override
    public void savePerson(Person person) {
        personList.add(person); // calling on my list, then adding the Person object to my list

    }

    @Override
    public void deletePerson(int id) {


    }

    @Override
    public List<Person> getPeople() {
        return personList;   // this is just getting our list of people - just printing the names
    }

    @Override
    public Person getPersonById(int id) {
        return null;
    }


}
