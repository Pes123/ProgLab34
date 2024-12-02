package Aclasses;

import enums.Material;

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

    public Material getMaterial() {
        return material;
    }
}
