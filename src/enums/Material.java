package enums;

public enum Material {
    NOTSTATED("Материал не определен"),
    STEEL("СТАЛЬ");

    private String type;
    Material(String type) {
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}
