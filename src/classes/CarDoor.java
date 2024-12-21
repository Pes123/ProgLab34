package classes;

import Aclasses.Door;
import Aclasses.Place;
import enums.Lighten;
import enums.Material;
import interfaces.Openable;

public class CarDoor extends Door implements Openable {

    public CarDoor(Material material, Place place) {
        super(material, place);
    }

    @Override
    public void open(Lighten lighten) {
        isOpened = true;
        System.out.println("Дверь машины отварилась можно заваливаться");
    }

    @Override
    public String toString() {
        return "CarDoor{}";
    }
}
