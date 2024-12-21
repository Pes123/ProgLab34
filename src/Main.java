import classes.*;
import enums.Distance;
import enums.Lighten;
import enums.Material;
import records.DrivingLicense;

public class Main {
    public static void main(String[] args) {



        PlaceWithSomething storage = new PlaceWithSomething("Хранилище", Lighten.getRandomLighten(), Distance.CLOSE, null);
        //PlaceWithSomething storage = new PlaceWithSomething("Хранилище", Lighten.BRIGHT, Distance.CLOSE, null);
        StorageDoor storageDoor = new StorageDoor(Material.STEEL, storage);
        storage.addThingsHere(storageDoor);


        PlaceWitoutSomething hall = new PlaceWitoutSomething("Коридор", Lighten.getRandomLighten(), Distance.CLOSE, storage);

        PlaceWitoutSomething stairs = new PlaceWitoutSomething("лЕсница", Lighten.getRandomLighten(), Distance.CLOSE, hall);
        //PlaceWitoutSomething stairs = new PlaceWitoutSomething("лЕсница", Lighten.BRIGHT, Distance.CLOSE, hall);


        PlaceWithSomething garage = new PlaceWithSomething("Гараж", Lighten.getRandomLighten(), Distance.CLOSE, stairs);
        //PlaceWithSomething garage = new PlaceWithSomething("Гараж", Lighten.BRIGHT, Distance.CLOSE, stairs);
        Car car = new Car(Material.STEEL, garage);
        garage.addThingsHere(car);

        PlaceWithSomething undergroundTunnel = new PlaceWithSomething("Тоннель", Lighten.DARK, Distance.FARAWAY, garage);

        PlaceWithSomething policeOffice = new PlaceWithSomething("Полицейский участок", Lighten.BRIGHT,Distance.FARAWAY, undergroundTunnel);

        Person julio = new Person("Жулио", "boy", storage);
        Person neznaika = new Person("Незнайка", "boy", storage);
        Person kozlik = new Person("Козлик", "boy", storage );
        DrivingLicense drivingLicens = new DrivingLicense("Жулио", 123);
        Keys keys = new Keys(Material.STEEL, 1);
        julio.setKeys(keys);
        julio.setDrivingLicense(drivingLicens);

        Person[] group = {julio, neznaika, kozlik};

        julio.openDoor(storageDoor);
        for (Person person: group){
            person.moveToTargetPlace(hall);
        }
        for (Person person: group) {
            person.moveToTargetPlace(stairs);
        }
        for (Person person: group) {
            Lighten lighten = stairs.getLighten();
            if (lighten == Lighten.DARK){
                System.out.println("На лестнице слишком темно все пчелики попадали с нее и померли");
                System.exit(0);
            } else if (lighten == Lighten.SEMIDARK) {
                if (Math.random() <= 0.5){
                    System.out.println(person.getName() + " из-за плохого освещения свалился с лестницы и ...");
                    System.exit(0);
                }
                else {
                    System.out.println("Бог уберег и " + person.getName() + " смог спустится в потемках");
                    person.moveToTargetPlace(garage);
                }
            }
            else {
                System.out.println("К счастью на лестнице достаточно светло и " + person.getName() + " смог спуститься");
                person.moveToTargetPlace(garage);
            }
        }
        julio.openDoor(car.getCarDoor());
        for (Person person: group) {
            person.sitInCar(car);
        }
        julio.moveToTargetPlace(undergroundTunnel);
        julio.moveToTargetPlace(policeOffice);

        boolean lost = false;

        for (Person person: group) {
            if (person.getPlace().equals(policeOffice)){
                System.out.println(person.getName() + " выжил и добрался до места назначения");
            }
            else{
                System.out.println(person.getName() + " был потерян по пути");
                lost = true;
            }
        }
        if (lost){
            System.out.println("К сожалению не все смогли добраться...........");
        }
        else {
            System.out.println("К счастью все добрались");
        }
    }
}