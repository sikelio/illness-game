package wtf.sikelio;

public abstract class Illness {
    public String name;
    public Integer strength;
    public Integer danger;
    public String symptoms;

    public Illness(String name, Integer strength, Integer danger, String symptoms) {
        this.name = name;
        this.strength = strength;
        this.danger = danger;
        this.symptoms = symptoms;
    }

    public boolean state() {
        return this.strength == 0;
    }

    public String toString() {
        return "Illness: " + this.name + " - Danger: " + this.danger + " - Strength: " + this.strength;
    }

    public abstract int evolve();

    public abstract boolean treat(Medicine medicine);
}
