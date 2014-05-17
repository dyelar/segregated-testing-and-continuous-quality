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
import org.junit.Test;

/**
 * This class provides tests to verify
 * that invalid arguments to the constructor
 * aren't allowed.
 */
public class PersonTest {

    private static final String name = "Joe";
    private static final String id = "0";

    @Test(expected=IllegalArgumentException.class)
    public void testSingleArgConstructorNullName() {
        Person person = new Person(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSingleArgConstructorBlankName() {
        Person person = new Person("");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testTwoArgConstructorNullName() {
        Person person = new Person(id,null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testTwoArgConstructorBlankName() {
        Person person = new Person(id,"");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testTwoArgConstructorNullId() {
        Person person = new Person(null,name);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testTwoArgConstructorBlankId() {
        Person person = new Person("",name);
    }
}
