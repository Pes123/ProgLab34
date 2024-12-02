package classes;

import Aclasses.Door;
import Aclasses.Place;
import enums.Lighten;
import enums.Material;
import interfaces.Clickable;
import interfaces.Openable;


public class StorageDoor extends Door implements Openable {

    public StorageDoor(Material material, Place place) {
        super(material, place);
    }
    Button button = new Button(Material .STEEL);

    @Override
    public void open(Lighten lighten) {
        if (lighten == Lighten.DARK){
            System.out.println("Слишком темно не могу нажать на кнопку");
        } else if (lighten == Lighten.SEMIDARK) {
            if (Math.random() <= 0.5){
                System.out.println("С трудом нащупал кнопку блин");
                button.click();
            }
        } else {
            button.click();
        }
        if (button.isClicked){
            System.out.println("Кнопка была нажата, дверь отпирается");
            isOpened = true;
        }
        else {
            System.out.println("Нажмите кнопку для открытия двери");
        }
    }

    private class Button implements Clickable {
        boolean isClicked = false;
        Material material;
        public Button(Material material){
            this.material = material;
        }
        @Override
        public void click() {
            System.out.println("нажал кнопку");
            isClicked = true;
        }
    }
    @Override
    public String toString(){
        return "Дверь хранилища";
    }
}
