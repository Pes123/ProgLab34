package Aclasses;

import enums.Material;

import java.util.Objects;

public abstract class Door extends InteractableThings  {
    protected boolean isOpened;


    public Door(Material material, Place place) {
        super(material, place);
        isOpened = false;
    }

    public boolean getIsOpened(){
        return isOpened;
    }

    @Override
    public String toString() {
        return "Door{" +
                "isOpened=" + isOpened +
                '}';
    }

}