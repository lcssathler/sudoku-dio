package entities;

public class Space {
    private final boolean fixed;
    private Integer actual;

    public Space(boolean fixed, Integer actual) {
        this.fixed = fixed;
        this.actual = actual;
    }

    @Override
    public String toString() {
        return "Space{" +
                "fixed=" + fixed +
                ", actual=" + actual +
                '}';
    }

    public Integer getActual() {
        return actual;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setActual(Integer actual) {
        this.actual = actual;
    }
}
