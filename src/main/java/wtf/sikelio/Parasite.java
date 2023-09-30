package wtf.sikelio;

public class Parasite extends Illness {
    public Parasite(String name, Integer strength, Integer danger, String symptoms) {
        super(name, strength, danger, symptoms);
    }

    @Override
    public int evolve() {
        return 3;
    }

    @Override
    public boolean treat(Medicine medicine) {
        if (medicine.getType().equals(Type.Antiparasite)) {
            this.strength = 0;
        } else {
            this.strength -= 20;
        }

        return this.state();
    }
}
