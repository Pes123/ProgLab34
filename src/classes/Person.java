package classes;


import Aclasses.Door;
import Aclasses.InteractableThings;
import Aclasses.Place;
import enums.Distance;
import enums.Lighten;
import enums.Status;
import exceptions.DoorIsntOpenException;
import records.DrivingLicense;

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
    // так как у меня есть два класса места с объектами внутри и без объектов внутри
    // я проверяю к какому классу относится место в котором сейчас находится пчелик
    // и создаю объект этого места на основе исходного place ( спомощью приведения)
    // чтобы работать с нужными методами
    public void changePlace(){
        if (this.place.getDistance().equals(Distance.CLOSE)) {
            changeClosePlace(this.place);
        }
    }

    private void changeClosePlace(Place place) {
        if (place instanceof PlaceWithSomething && place.getDistance().equals(Distance.CLOSE) ) {
            PlaceWithSomething tempPlace = (PlaceWithSomething) place;
            for (InteractableThings things : tempPlace.getThingsHere()) {
                if (things instanceof Door) {
                    Door door = (Door) things;
                    if (door.getIsOpened()) {
                        this.place.removePersonHere(this);
                        this.place = place;
                        this.place.addPersonHere(this);
                        System.out.println(name + "Переместился в " + place.getName());
                    } else {
                        throw new DoorIsntOpenException("Дверь закрыта блинб");
                    }
                }
            }
        }
    }

    public void openDoor(StorageDoor door){
        door.open(this.getPlace().getLighten());
    }
    public void openDoor(CarDoor door){

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
}
