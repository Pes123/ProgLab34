package classes;

import Aclasses.InteractableThings;
import Aclasses.Place;
import enums.Material;
import exceptions.AlotPeopleInCarException;

import java.util.ArrayList;
import java.util.Objects;

public class Car extends InteractableThings {
    private Place place;
    private CarDoor carDoor = new CarDoor(Material.STEEL, this.place);
    private ArrayList<Person> whoIsSitingHere = new ArrayList<Person>();

    public Car(Material material, Place place) {
        super(material, place);
    }

    public void drive(Place targetPlace) {
        for (Person person: whoIsSitingHere){
            person.changePlace(targetPlace);
        }
    }
    public ArrayList<Person> getWhoIsSitingHere() {
        return whoIsSitingHere;
    }

    public void addSomeone(Person person) throws AlotPeopleInCarException {
        if (this.whoIsSitingHere.size() > 4){
            throw new AlotPeopleInCarException("Пчелики не влезают");
        }
        else{
            whoIsSitingHere.add(person);
        }
    }

    public void removeSomeone(Person person) {
        whoIsSitingHere.remove(person);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Objects.equals(place, car.place) && Objects.equals(carDoor, car.carDoor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place, carDoor);
    }

    public CarDoor getCarDoor() {
        return carDoor;
    }

    @Override
    public String toString() {
        return "Car{" +
                "place=" + place +
                ", carDoor=" + carDoor +
                ", whoIsSitingHere=" + whoIsSitingHere +
                "} " + super.toString();
    }
}
