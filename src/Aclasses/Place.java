package Aclasses;

import classes.Person;
import enums.Distance;
import enums.Lighten;

import java.util.ArrayList;

public abstract class Place {
    private String name;
    private ArrayList<Person> personHere = new ArrayList<Person>();
    private Distance distance;
    private Lighten lighten;

    public Place(String name, Lighten lighten, Distance distance){
        this.name = name;
        this.lighten = lighten;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void addPersonHere(Person person) {
        personHere.add(person);
    }

    public void removePersonHere(Person person) {
        personHere.remove(person);
    }


    public ArrayList<Person> getPersonHere() {
        return personHere;
    }

    public void setPersonHere(ArrayList<Person> personHere) {
        this.personHere = personHere;
    }

    public Distance getDistance() {
        return distance;
    }

    public Lighten getLighten() {
        return lighten;
    }
}
