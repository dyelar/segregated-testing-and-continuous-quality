package tk.dyelar.person.service.impl;
/*
Copyright 2014 Matthew M. Copeland

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
import org.junit.Before;
import org.junit.Test;
import tk.dyelar.person.dao.PersonDao;
import tk.dyelar.person.dao.impl.PersonDaoImpl;
import tk.dyelar.person.model.Person;
import tk.dyelar.person.service.PersonService;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * PersonService/PersonDao Integration Tests
 */
public class PersonServiceImplIT {

    PersonService personService;
    PersonDao personDao;

    @Before
    public void setup() {
        personDao = new PersonDaoImpl();
        personService = new PersonServiceImpl(personDao);
    }


    @Test
    public void testAddPerson() {

        String name = "Matthew Copeland";
        String id = personService.addPerson(new Person(name));
        Person person = personService.getPerson(id);
        assertTrue("The Person Service was unable to locate a person object with the ID returned by addPerson.",person != null);
        name = "Matthew Copeland";
        assertEquals("The person returned from the Person Service didn't have the correct name.", name.toUpperCase(), person.getName());

    }

    @Test
    public void testFindPersonByName() {
        String name = "Matthew Copeland";
        personService.addPerson(new Person(name));
        Person person = personService.findPersonByName(name);
        assertTrue("The Person Service was unable to locate a person object with the ID returned by addPerson.",person != null);
        assertEquals("The person returned from the Person Service didn't have the correct name.", name.toUpperCase(), person.getName());
    }

    @Test
    public void testGetPersonById() {

        final String name = "John Smith";
        Person person = personService.getPerson("0");
        assertEquals("The person returned from the Person Service didn't have the correct name.", name.toUpperCase(), person.getName());
    }

    @Test
    public void testDeletePerson() {
        final String name = "John Smith";
        final String personId = "0";
        personService.deletePerson(personId);
        assertNull("The person service should not have been able to find a value for this id.", personService.getPerson("0"));
        assertNull("The person service should not have been able to find a value for this name.", personService.findPersonByName(name));
    }

    @Test
    public void testAddPersonForUniqueness() {
        final String name = "John Smith";
        final String personId = "0";
        Person person = new Person(name);

        personService.addPerson(person);
        personService.deletePerson(personId);

        assertNull("The person service should not have been able to find a value for this id.", personService.getPerson(personId));
        assertNull("The person service should not have been able to find a value for this name.", personService.findPersonByName(name));
    }
}
