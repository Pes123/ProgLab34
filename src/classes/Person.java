package classes;


import Aclasses.Door;
import Aclasses.InteractableThings;
import Aclasses.Place;
import enums.Distance;
import enums.Status;
import exceptions.DoorIsntOpenException;
import exceptions.ThereIsNoCarException;
import records.DrivingLicense;

import java.util.Objects;

public class Person {
    final private String name;
    final private String sex;
    private Place place;
    private DrivingLicense drivingLicense;
    private Status status;
    private Keys  keys;
    public Person(String name, String sex, Place place){
        this.name = name;
        this.sex = sex;
        this.place = place;
    }
    void changePlace(Place targetPlace){
        this.place.removePersonHere(this);
        this.place = targetPlace;
        this.place.addPersonHere(this);
    }
    // так как у меня есть два класса места с объектами внутри и без объектов внутри
    // я проверяю к какому классу относится место в котором сейчас находится пчелик
    // и создаю объект этого места на основе исходного place ( спомощью приведения)
    // чтобы работать с нужными методами
    public void MoveToTargetPlace(Place targetPlace) throws ThereIsNoCarException {
        if (targetPlace.getDistance().equals(Distance.CLOSE)) {
            changeClosePlace(targetPlace);
        }
        // это нужно чтобы среди всех обьектов находящихся в месте найти машину и передать
        // ее в следующую функцию
        else {
            Car car = null;
            if (this.place instanceof PlaceWithSomething) {
                PlaceWithSomething tempPlace = (PlaceWithSomething) this.place;
                for (InteractableThings things : tempPlace.getThingsHere()){
                    if (things instanceof Car){
                        car = (Car) things;
                        break;
                    }
                }
            }
            if (car != null) {
                changeFarPlace(targetPlace, car);
            } else {
                throw new ThereIsNoCarException("нет тут тачки блин");
            }
        }
    }
    public void changeFarPlace(Place targetPlace,Car car){
        if (drivingLicense != null){
            car.drive(targetPlace);
        }
    }



    private void changeClosePlace(Place targetPlace) {
        if (this.place instanceof PlaceWithSomething) {
            PlaceWithSomething tempPlace = (PlaceWithSomething) this.place;
            for (InteractableThings things : tempPlace.getThingsHere()) {
                if (things instanceof Door) {
                    Door door = (Door) things;
                    if (door.getIsOpened()) {
                        changePlace(targetPlace);
                        System.out.println(name + "Переместился в " + place.getName());
                    } else {
                        throw new DoorIsntOpenException("Дверь закрыта блинб");
                    }
                }
            }
        }
        else {
            changePlace(targetPlace);
        }
    }

    public void openDoor(StorageDoor door){
        door.open(this.getPlace().getLighten());
    }

    public void sitInCar(Car car){
        if (car.getCarDoor().getIsOpened()){
            setStatus(Status.SITTING);
            car.addSomeone(this);
        }
        else {
            throw new DoorIsntOpenException("Дверь не отварилась блинб");
        }
    }
    public void openDoor(CarDoor door){
        if (keys != null){
            door.open(this.getPlace().getLighten());
        }

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(name, person.name) && Objects.equals(sex, person.sex) && Objects.equals(drivingLicense, person.drivingLicense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, drivingLicense);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", place=" + place +
                ", drivingLicense=" + drivingLicense +
                ", status=" + status +
                ", keys=" + keys +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public DrivingLicense getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(DrivingLicense drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public Keys getKeys() {
        return keys;
    }

    public void setKeys(Keys keys) {
        this.keys = keys;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
