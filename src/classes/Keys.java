package classes;

import enums.Material;

import java.util.Objects;

public class Keys{

    private Material material;
    private int id;

    public Keys(Material material, int id) {
        this.material = material;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Keys{" +
                "material=" + material +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Keys keys)) return false;
        return id == keys.id && material == keys.material;
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, id);
    }

    public Material getMaterial() {
        return material;
    }

    public int getId() {
        return id;
    }

}
