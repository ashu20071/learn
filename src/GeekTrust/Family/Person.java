package GeekTrust.Family;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Class containing all info about a person like name, gender, primary relations.
 */

enum Gender {
    MALE,
    FEMALE
}

public class Person {
    // Primary relations
    private final String name;
    private final Gender gender;
    private final Person mother;
    private final List<Person> siblings;

    // After marriage
    private Person spouse;
    private final List<Person> children;

    public Person(String name, Person mother, Gender gender) {
        this.name = name;
        this.mother = mother;
        this.gender = gender;
        this.siblings = setSiblings();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return mother.getSpouse();
    }

    private List<Person> setSiblings() {
        List<Person> siblings = new ArrayList<>();
        for (Person child : mother.getChildren()) {
            if (!child.getName().equals(name))
                siblings.add(child);
        }
        return siblings;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSpouse(@NotNull Person spouse) {
        this.spouse = spouse;
    }

    public Person getSpouse() {
        return spouse;
    }

    public List<Person> getChildren() {
        return children;
    }

}
