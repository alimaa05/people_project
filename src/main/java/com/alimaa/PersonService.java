package com.alimaa;

import java.util.List;
import java.util.Optional;

public class PersonService {

    // BUSINESS LOGIC I.E. SERVICE LAYER
    // BUSINESS LOGIC RUNS THE CHECKS THEN CALLS DAO IF CHECKS PASS

    // THE BUSINESS LOGIC IS CHECKING EVERYTHING THAT'S BEING IMPLEMENTED IS CORRECT (CORRECT DATA TYPE ETC.) BUT IS DOESN'T TELL US HOW TO CARRY OUR THE METHOD
    // HOW IT'S SHOULD BE CARRIED OUT IS DONE IN THE IMPLEMENTATION OF THE DAO

    private final PersonDAO personDAO;

    // CONSTRUCTOR
    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    // METHOD - THE BUSINESS LOGIC - TO SAVE A PERSON
    // ACCEPTS PERSON OBJECT
    public void savePerson(Person person) {
        // IF ANY OF THESE CONDITIONS ARE MET I.E THEY HAVEN'T GIVEN AN AGE OR ID OR THEIR NAME IS EQUAL 0
        if (person.getAge() == null ||
                person.getId() == null ||
                person.getName().length() == 0) {
            // THEN IT WILL THROW AN EXCEPTION
            throw new IllegalStateException("Person cannot have empty fields");
        }

        // CREATING BOOLEAN VARIABLE - TO CALL ON THE METHOD BELOW
        boolean exists = doesPersonWithIdExists(person.getId());

        //
        if (exists) {
            throw new IllegalStateException("person with id " + person.getId() + " already exists");
        }

        // IF IT DOESN'T EXIST ITS CALLING ON PersonDAO - THEN THE SAVEPERSON METHOD - IN PARENTHESIS IT WILL SAVE THE PERSON LIST
        personDAO.savePerson(person);
    }


    // METHOD TO DELETE PERSON - ACCEPTS INT ID
    public void deletePerson(int id) {
        // CALLS ON THE METHOD
        boolean exists = doesPersonWithIdExists(id);
        // IF IT DOESN'T EXIST
        if (!exists) {
            // THROW EXCEPT TO SAY YOU CANT DELETE IT BEC DOESN'T EXIST
            throw new IllegalStateException("person with id " + id + " not found");
        } // ELSE WILL DELETE PERSON - CALLS ON PersonDAO - THEN THE DELETE METHOD - AND THEN THE ID
        personDAO.deletePerson(id);
    }


    // METHOD TO VIEW ALL PEOPLE IN THE LIST - RETURNING THE LIST
    public List<Person> getPeople() {
        return personDAO.getPeople();
    }

    // METHOD TO SEARCH FOR SPECIFIC ID AND THEN GET THE PERSON AND RETURN IT
    public Optional<Person> getPersonById(int id) {
        return personDAO
                .getPeople()
                .stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    // METHOD - RETURNS BOOLEAN - METHOD CALLED doesPersonWithIdExists - ACCEPTS INTEGER ID
    private boolean doesPersonWithIdExists(Integer id) {
        return personDAO
                // THESE ARE THE CHECKS - MAKES SURE SOMEONE WITH THIS ID DOESN'T ALREADY EXIST
                .getPeople()
                .stream()
                .anyMatch(p -> p.getId().equals(id));
    }


}
