package tk.dyelar.person.dao.impl;
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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 *
 *
 */
public class PersonDaoImpl implements PersonDao {

    private Map<String, Person> people = new HashMap<>();
    private int nextPersonId=0;
    private final long delayLength=10;

    public PersonDaoImpl() {
        addPerson(new Person("John Smith".toUpperCase()));
        addPerson(new Person("Pierce Austin".toUpperCase()));
        addPerson(new Person("Jacob House".toUpperCase()));
    }

    private void introduceDelay() {
        try {
            Thread.sleep(delayLength);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String addPerson(Person person) {
        introduceDelay();
        String id = Integer.toString(nextPersonId);
        people.put(id,person);
        nextPersonId++;
        return id;
    }

    @Override
    public void deletePerson(String id) {
        introduceDelay();
        people.remove(id);
    }

    @Override
    public Person getPerson(String id) {
        introduceDelay();
        return people.get(id);
    }

    @Override
    public Person findPersonByName(String name) {
        introduceDelay();

        Person result=null;
        Set<String> keysSet = people.keySet();

        for(String key : keysSet) {
            Person candidate = people.get(key);
            if(StringUtils.equals(name, candidate.getName())) {
                result = candidate;
                break;
            }
        }
        return result;
    }
}
