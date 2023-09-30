package wtf.sikelio;

public class Virus extends Illness {
    public Virus(String name, Integer strength, Integer danger, String symptoms) {
        super(name, strength, danger, symptoms);
    }

    @Override
    public int evolve() {
        double lifePoint = (float)this.strength / 25;

        return (int)lifePoint;
    }

    @Override
    public boolean treat(Medicine medicine) {
        switch (medicine.getType()) {
            case Antiviral:
                this.strength -= 10;
                break;
            case Antibiotic:
                this.strength--;
                break;
        }

        return this.state();
    }
}
