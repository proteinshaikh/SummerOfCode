package Winter2022.equalshashcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Building {

    private String name;
    private int roomno;

    public Building(String name, int roomno) {
        this.name = name;
        this.roomno = roomno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomno() {
        return roomno;
    }

    public void setRoomno(int roomno) {
        this.roomno = roomno;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        if (!(o instanceof Building)) {
            return false;
        }

        Building building = (Building) o;
        return building.getRoomno() == this.getRoomno() && building.getName().equals(this.getName());
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + roomno;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

public class testEqualsandHashcode {
    public static void main(String[] args) {
        List<Building> list = new ArrayList<>();
        Building b1 = new Building("zeeshan", 1);
        Building b2 = new Building("zeeshan", 1);
        list.add(b1);
        list.add(b2);

        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
        System.out.println(b1.getRoomno() == b2.getRoomno());

    }
}
