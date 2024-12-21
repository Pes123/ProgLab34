package classes;

import Aclasses.Place;
import enums.Distance;
import enums.Lighten;

import java.awt.*;
import java.util.Objects;

public class PlaceWitoutSomething extends Place {

    public PlaceWitoutSomething(String name, Lighten lighten, Distance distance, Place previousPlace) {
        super(name, lighten, distance, previousPlace);
    }

}