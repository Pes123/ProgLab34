package classes;

import Aclasses.Place;
import enums.Distance;
import enums.Lighten;

import java.awt.*;
import java.util.Objects;

public class PlaceWitoutSomething extends Place {

    public PlaceWitoutSomething(String name, Lighten lighten, Distance distance) {
        super(name, lighten, distance);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PlaceWitoutSomething)) return false;
        PlaceWitoutSomething other = (PlaceWitoutSomething) obj;
        return this.getName().equals(other.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "PlaceWitoutSomething{name='" + getName() + "'}";
    }
}