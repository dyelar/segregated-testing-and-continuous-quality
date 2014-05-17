package tk.dyelar.person.service;

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

import tk.dyelar.person.model.Person;


/**
 * Service to perform business rules on a Person
 * prior to calling a persistence layer to save
 * the data.
 */
public interface PersonService {

    /**
     *
     * Adds a new person to the system.
     *
     *
     * @param person The Person to add to the system.
     * @return The id now associated with the person.
     */
    String addPerson(Person person);

    /**
     * Remove a person from the system.
     *
     * @param id The id of the person to remove from the system.
     */
    void deletePerson(String id);

    /**
     * Retrieve the person from the system with the associated id.
     *
     * @param id The id of the person to retrieve from the system.
     * @return The person with the associated ID.
     */
    Person getPerson(String id);

    /**
     * Retrieve the person from the system with the associated name.
     *
     * @param name The name of the person to find in the system
     * @return The Person with the associated name.
     */
    Person findPersonByName(String name);

}
