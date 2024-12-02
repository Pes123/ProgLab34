package enums;

public enum Distance {
    CLOSE("Близко, в одном здании"),
    FARAWAY("Далеко, блин");

    private String type;
    Distance(String type) {
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}
