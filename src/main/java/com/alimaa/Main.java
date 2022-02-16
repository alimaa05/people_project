package com.alimaa;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
public class Main {

	public static void main(String[] args) {
//		SpringApplication.run(Main.class, args);


		// making an instance of the specific implementation of the DAO i.e. interface class
		// which mean you can be more flexible and change the implementation class to a different thing e.g. SQL database or File
		PersonDAO personDAO = new PersonDataAccessService();

		// instance of the Service layer i.e. service class (business logic)
		// --> your always performing the same methods (just the method body for those specific implementations are different/ how you inact the method is different)
		// in the parenthesis we add the DAO interface because we want to be able to use the same service layer if we were to add a FILE or SQL DATABASE.
		PersonService personService = new PersonService(personDAO);

		Person alimaa = new Person(1,"Alimaa", 22);
		Person suad = new Person(2,"Suad", 23);
		Person suraya = new Person(3,"Suraya", 24);

		// making array of person object
		Person[] personArray = {alimaa, suad, suraya};
		//data type //placeholder //thing you're looping through
		// looping through personArray - each of these array elements are placed into the placeholder i.e 'person' for the person objects
		for (Person person : personArray) {
			personService.savePerson(person);
		}


		// do this without looping though an array
//		personService.savePerson(alimaa);
//		personService.savePerson(suad);
//		personService.savePerson(suraya);


		// calling on the business logic rather than the implementation because the business logic already has the DAO interface
		// and we already stated that the specific implementation of the interface class is the PersonDataAccessService
		System.out.println(personService.getPeople());



	}

}
