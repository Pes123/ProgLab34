package Aclasses;

import classes.Person;
import enums.Distance;
import enums.Lighten;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Place {
    private String name;
    private ArrayList<Person> personHere = new ArrayList<Person>();
    private Distance distance;
    private Lighten lighten;
    private Place previousPlace;

    public Place(String name, Lighten lighten, Distance distance, Place previousPlace){
        this.name = name;
        this.lighten = lighten;
        this.distance = distance;
        this.previousPlace = previousPlace;
    }

    public String getName() {
        return name;
    }

    public void addPersonHere(Person person) {
        personHere.add(person);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place place)) return false;
        return Objects.equals(name, place.name) && distance == place.distance && lighten == place.lighten;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance, lighten);
    }

    public void removePersonHere(Person person) {
        personHere.remove(person);
    }


    public ArrayList<Person> getPersonHere() {
        return personHere;
    }



    public Distance getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", personHere=" + personHere +
                ", distance=" + distance +
                ", lighten=" + lighten +
                '}';
    }

    public Lighten getLighten() {
        return lighten;
    }

    public void test() {
    }


    public Place getPreviousPlace() {
        return previousPlace;
    }


}
