package wtf.sikelio;

import java.util.Random;

public class Bacteria extends Illness {
    private Stage stage;
    private Random random = new Random();

    public Bacteria(String name, Integer strength, Integer danger, String symptoms) {
        super(name, strength, danger, symptoms);

        switch (this.random.nextInt(4)) {
            case 0:
                this.stage = Stage.Benin;
                break;
            case 1:
                this.stage = Stage.Moderate;
                break;
            case 2:
                this.stage = Stage.Dangerous;
                break;
            case 3:
                this.stage = Stage.Severe;
                break;
        }
    }

    @Override
    public int evolve() {
        double percent = 0;
        double random = Math.random();

        if (random <= 0.5) {
            this.strength += 5;
        } else {
            this.stage.next();
        }

        switch (this.stage) {
            case Benin:
                percent = 0.2 * this.strength;
                break;
            case Moderate:
                percent = 0.3 * this.strength;
                break;
            case Dangerous:
                percent = 0.7 * this.strength;
                break;
            case Severe:
                percent = 0.9 * this.strength;
                break;
        }

        return (int)percent;
    }

    @Override
    public boolean treat(Medicine medicine) {
        switch (this.stage) {
            case Benin:
                if (medicine.getType().equals(Type.Antibiotic)) {
                    this.strength = 0;
                } else if (medicine.getType().equals(Type.Antiviral)) {
                    this.strength -= 10;
                }
                break;
            case Moderate:
                if (medicine.getType().equals(Type.Antibiotic)) {
                    this.strength -= 10;
                } else if (medicine.getType().equals(Type.Antiviral)) {
                    this.strength -= 3;
                }
                break;
            case Dangerous:
                if (medicine.getType().equals(Type.Antibiotic)) {
                    this.stage = Stage.Moderate;
                }
                break;
            case Severe:
                if (medicine.getType().equals(Type.Antibiotic)) {
                    this.strength -= 5;
                }
                break;
        }

        return this.state();
    }
}
