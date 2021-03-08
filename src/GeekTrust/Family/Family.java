package GeekTrust.Family;

import java.util.List;

/**
 * Class containing all family members and method to retrieve person object by given name.
 */

public class Family {
    private final List<Person> familyMembers;

    public Family(List<Person> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public List<Person> getFamilyMembers() {
        return familyMembers;
    }

    public Person getPerson(String name) {
        for (Person person : familyMembers) {
            if (person.getName().equals(name))
                return person;
        }
        throw new IllegalArgumentException("Person not found");
    }
}
