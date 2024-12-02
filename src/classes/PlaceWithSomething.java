package classes;

import Aclasses.InteractableThings;
import Aclasses.Place;
import enums.Distance;
import enums.Lighten;

import java.util.ArrayList;
import java.util.Collections;

public class PlaceWithSomething extends Place {

    private ArrayList<InteractableThings> thingsHere = new ArrayList<>();

    public PlaceWithSomething(String name, Lighten lighten, Distance distance, InteractableThings[] things) {
        super(name, lighten, distance);
        Collections.addAll(thingsHere, things);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PlaceWithSomething)) return false;
        PlaceWithSomething other = (PlaceWithSomething) obj;
        return this.getName().equals(other.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public String toString() {
        return "PlaceWithSomething{name='" + getName() + "', thingsHere=" + thingsHere.toString() + "}";
    }

    public void addThingsHere(InteractableThings thing) {
        thingsHere.add(thing);
    }

    public ArrayList<InteractableThings> getThingsHere() {
        return thingsHere;
    }
}