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
import org.apache.commons.lang3.StringUtils;
import tk.dyelar.person.dao.PersonDao;
import tk.dyelar.person.model.Person;
import tk.dyelar.person.service.PersonService;


/**
 *
 *
 *
 */
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    public PersonServiceImpl(final PersonDao personDao) {
        if(personDao == null) {
            throw new IllegalArgumentException("Person Dao argument may not be null.");
        }
        this.personDao = personDao;
    }

    @Override
    public String addPerson(Person person) {
        Person personInSystem = this.findPersonByName(person.getName());
        String result=null;

        if(personInSystem == null) {
            Person personToAdd = new Person(StringUtils.upperCase(person.getName()));
            result = personDao.addPerson(personToAdd);
        } else {
            result = personInSystem.getId();
        }

        return result;
    }

    @Override
    public void deletePerson(String id) {
        personDao.deletePerson(id);
    }

    @Override
    public Person getPerson(String id) {
        return personDao.getPerson(id);
    }

    @Override
    public Person findPersonByName(String name) {
        return personDao.findPersonByName(StringUtils.upperCase(name));
    }


}
