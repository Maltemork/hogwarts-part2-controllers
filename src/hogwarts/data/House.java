package hogwarts.data;

public class House {
    private String name;
    private String founder;
    private String[] colors;

    public House(String name, String founder, String[] colors) {
        this.name = name;
        this.founder = founder;
        this.colors = colors;
    }

    public House(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFounder() {
        return founder;
    }

    public String[] getColors() {
        return colors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }
}
