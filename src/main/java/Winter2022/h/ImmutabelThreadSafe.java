package Winter2022.h;

import java.util.Objects;

public class ImmutabelThreadSafe {

    private final int id;
    private final String name;

    public ImmutabelThreadSafe(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutabelThreadSafe immutabelThreadSafe = (ImmutabelThreadSafe) o;
        return id == immutabelThreadSafe.id && name.equals(immutabelThreadSafe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
