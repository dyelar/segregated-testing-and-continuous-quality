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
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import tk.dyelar.person.dao.PersonDao;
import tk.dyelar.person.model.Person;
import tk.dyelar.person.service.PersonService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * This class is to unit test only the Service portion
 * of the PersonServiceImpl.
 */
public class PersonServiceImplTest {

    PersonService personService;

    @Test
    public void testAddPerson() {
        String name = "Matthew Copeland";
        Person person = new Person(name);
        String id = "0";

        PersonDao personDao = mock(PersonDao.class);
        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);
        when(personDao.addPerson(argument.capture())).thenReturn(id);
        personService = new PersonServiceImpl(personDao);

        String returnId = personService.addPerson(person);
        Person businessLogicResultPerson = argument.getValue();

        assertEquals("The person returned from the Person Service didn't have the correct name.", name.toUpperCase(), businessLogicResultPerson.getName());
        assertEquals("The id provided by the DAO wasn't value returned by the service object.", id, returnId);
    }

    @Test
    public void testAddPersonWithAlreadyExistingPerson() {
        final String name = "Matthew Copeland";
        final String id = "0";
        Person person = new Person(id,name);

        PersonDao personDao = mock(PersonDao.class);
        when(personDao.findPersonByName(anyString())).thenReturn(person);
        personService = new PersonServiceImpl(personDao);

        String returnId = personService.addPerson(person);
        assertEquals("The id provided by the DAO wasn't value returned by the service object.", id, returnId);
    }

    @Test
    public void testFindPersonByName() {

        String name = "Matthew Copeland";
        String id = "0";
        Person person = new Person(id,name.toUpperCase());

        PersonDao personDao = mock(PersonDao.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        when(personDao.findPersonByName(argument.capture())).thenReturn(person);
        personService = new PersonServiceImpl(personDao);

        Person resultPerson = personService.findPersonByName(name);
        String businessLogicResultName = argument.getValue();
        assertTrue("The person returned from the Person Service didn't have the correct name.",resultPerson != null);
        assertEquals("The person returned from the Person Service didn't have the correct name.", name.toUpperCase(),businessLogicResultName);
    }

    @Test
    public void testGetPersonById() {
        final String name = "John Smith";
        final String id = "0";
        Person person = new Person(id,name.toUpperCase());

        PersonDao personDao = mock(PersonDao.class);
        when(personDao.getPerson(id)).thenReturn(person);
        personService = new PersonServiceImpl(personDao);

        Person resultPerson = personService.getPerson("0");
        assertEquals("The person returned from the Person Service didn't have the correct name.", name.toUpperCase(), resultPerson.getName());
        verify(personDao, times(1)).getPerson(id);
    }

    @Test
    public void testDeletePerson() {
        final String personId = "0";

        PersonDao personDao = mock(PersonDao.class);
        personService = new PersonServiceImpl(personDao);

        personService.deletePerson(personId);
        verify(personDao).deletePerson(personId);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNullArgumentConstructor() {
        PersonService personSerivce = new PersonServiceImpl(null);
    }
}
