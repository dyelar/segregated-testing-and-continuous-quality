package tk.dyelar.person.model;
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

/**
 * Created by matthewc on 4/29/14.
 */
public class Person {

    private String id;

    private String name;

    public Person(String name) {
        if(StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Name may not be blank.");
        }
        this.name = name;
    }

    public Person(String id, String name) {
        if(StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Name may not be blank for a Person object.");
        }
        if(StringUtils.isBlank(id)) {
            throw new IllegalArgumentException("Id may not be blank for a Person object.");
        }
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
