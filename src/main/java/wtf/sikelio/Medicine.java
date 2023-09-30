package wtf.sikelio;

public class Medicine {
    private String name;
    private Type type;

    public Medicine(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String toString() {
        return this.name + " - " + this.type;
    }
}
