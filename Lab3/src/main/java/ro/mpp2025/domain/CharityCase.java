package ro.mpp2025.domain;

public class CharityCase extends Entity<Integer>{
    private String name;

    public CharityCase(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
