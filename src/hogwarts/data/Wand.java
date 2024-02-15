package hogwarts.data;

public class Wand extends TeachingMaterial {
    private double lengthInInches;
    private String wood;
    private String core;

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public double getLengthInInches() {
        return lengthInInches;
    }

    public void setLengthInInches(double lengthInInches) {
        this.lengthInInches = lengthInInches;
    }
}
