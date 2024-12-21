package enums;

import java.util.Random;

public enum Lighten {
    BRIGHT("Светло"),
    SEMIDARK("Потемки"),
    DARK("Темно");

    private String type;
    Lighten(String type) {
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    private static final Random rand = new Random();

        public static Lighten getRandomLighten()  {
        Lighten[] directions = values();
        return directions[rand.nextInt(directions.length)];
    }
}
