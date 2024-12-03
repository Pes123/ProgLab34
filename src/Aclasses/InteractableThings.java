package Aclasses;

import enums.Material;

import java.util.Objects;

public abstract class InteractableThings {
    private Material material;
    private Place place;
    public InteractableThings(Material material, Place place){
        this.material = material;
        this.place = place;
    }

    public Place getPlace() {
        return place;
    }

    @Override
    public String toString() {
        return "InteractableThings{" +
                "material=" + material +
                ", place=" + place +
                '}';
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InteractableThings things)) return false;
        return material == things.material && Objects.equals(place, things.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, place);
    }
}
