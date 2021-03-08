package GeekTrust.Family;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Class containing methods to set initial relations when person is created.
 * Retrieves all derived relations.
 */

public class Relations {

    /**
     * Method to add given person in relations of primary relatives
     * To be used only when new person is created
     */
    public static void setRelations(@NotNull Person person) {
        person.getMother().getChildren().add(person);
        person.getFather().getChildren().add(person);
        for (Person sibling : person.getSiblings())
            sibling.getSiblings().add(person);
    }


    public List<Person> getBrother(@NotNull Person person) {
        List<Person> brother = new ArrayList<>();
        for (Person sibling : person.getSiblings()) {
            if (sibling.getGender() == Gender.MALE)
                brother.add(sibling);
        }
        return brother;
    }

    public List<Person> getSister(@NotNull Person person) {
        List<Person> sister = new ArrayList<>();
        for (Person sibling : person.getSiblings()) {
            if (sibling.getGender() == Gender.FEMALE)
                sister.add(sibling);
        }
        return sister;
    }

    public List<Person> getSon(@NotNull Person person) {
        List<Person> son = new ArrayList<>();
        for (Person child : person.getChildren()) {
            if (child.getGender() == Gender.MALE)
                son.add(child);
        }
        return son;
    }

    public List<Person> getDaughter(@NotNull Person person) {
        List<Person> daughter = new ArrayList<>();
        for (Person child : person.getChildren()) {
            if (child.getGender() == Gender.FEMALE)
                daughter.add(child);
        }
        return daughter;
    }

    public List<Person> getBrotherInLaw(@NotNull Person person) {
        List<Person> brotherInLaw = new ArrayList<>();
        for (Person sister : getSister(person))
            brotherInLaw.add(sister.getSpouse());
        if (person.getSpouse() != null)
            brotherInLaw.addAll(getBrother(person.getSpouse()));
        return brotherInLaw;
    }

    public List<Person> getSisterInLaw(@NotNull Person person) {
        List<Person> sisterInLaw = new ArrayList<>();
        for (Person brother : getBrother(person))
            sisterInLaw.add(brother.getSpouse());
        if (person.getSpouse() != null)
            sisterInLaw.addAll(getSister(person.getSpouse()));
        return sisterInLaw;
    }

    /*public List<Person> getPaternalUncle() {
        return paternalUncle;
    }

    public List<Person> getMaternalUncle() {
        return maternalUncle;
    }

    public List<Person> getPaternalAunt() {
        return paternalAunt;
    }

    public List<Person> getMaternalAunt() {
        return maternalAunt;
    }*/

}
