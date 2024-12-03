package classes;

import Aclasses.InteractableThings;
import Aclasses.Place;
import enums.Distance;
import enums.Lighten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class PlaceWithSomething extends Place {

    private ArrayList<InteractableThings> thingsHere = new ArrayList<>();



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlaceWithSomething that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(thingsHere, that.thingsHere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), thingsHere);
    }

    public PlaceWithSomething(String name, Lighten lighten, Distance distance, InteractableThings[] things) {
        super(name, lighten, distance);
        Collections.addAll(thingsHere, things);
    }

    @Override
    public String toString() {
        return "PlaceWithSomething{" +
                "thingsHere=" + thingsHere +
                "} " + super.toString();
    }

    public void addThingsHere(InteractableThings thing) {
        thingsHere.add(thing);
    }

    public ArrayList<InteractableThings> getThingsHere() {
        return thingsHere;
    }
}