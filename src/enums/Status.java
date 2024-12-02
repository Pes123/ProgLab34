package enums;

public enum Status {
    SITTING("Сидит"),
    STANDING("Стоит");

    private String type;
    Status(String type) {
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}
