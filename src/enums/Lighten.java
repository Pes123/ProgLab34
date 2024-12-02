package enums;

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
}
