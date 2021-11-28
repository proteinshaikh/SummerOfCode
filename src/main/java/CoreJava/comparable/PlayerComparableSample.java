package CoreJava.comparable;

import java.util.Objects;

public class PlayerComparableSample implements Comparable<PlayerComparableSample> {

    private String name;
    private int rank;

    public PlayerComparableSample(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerComparableSample playerComparableSample = (PlayerComparableSample) o;
        return rank == playerComparableSample.rank && name.equals(playerComparableSample.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rank);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Player{");
        sb.append("name='").append(name).append('\'');
        sb.append(", rank=").append(rank);
        sb.append('}');
        return sb.toString();
    }


    @Override
    public int compareTo(PlayerComparableSample otherPlayerComparableSample) {
        return Integer.compare(getRank(), otherPlayerComparableSample.getRank());
    }
}
