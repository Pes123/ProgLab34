package classes;

import Aclasses.InteractableThings;
import Aclasses.Place;
import enums.Material;
import exceptions.AlotPeopleInCarException;

import java.util.ArrayList;
import java.util.Objects;

public class Car extends InteractableThings {

    private ArrayList<Person> whoIsSitingHere = new ArrayList<Person>();

    public Car(Material material, Place place) {
        super(material, place);
    }
    private CarDoor carDoor = new CarDoor(Material.STEEL, getPlace());

    public void drive(PlaceWithSomething targetPlace) {
        for (Person person: whoIsSitingHere){
            person.changePlace(targetPlace);
            targetPlace.addThingsHere(this);
        }
    }
    public ArrayList<Person> getWhoIsSitingHere()    {
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
        return Objects.equals(getCarDoor(), car.getPlace()) && Objects.equals(carDoor, car.carDoor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlace(), carDoor);
    }

    public CarDoor getCarDoor() {
        return carDoor;
    }

    @Override
    public String toString() {
        return "Car{" +
                "whoIsSitingHere=" + whoIsSitingHere +
                '}';
    }
}
