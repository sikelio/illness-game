package wtf.sikelio;

import java.lang.invoke.DelegatingMethodHandle$Holder;
import java.util.HashSet;

public class Patient {
    private String firstname;
    private String lastname;
    private Double lifePoint;
    private Double age;
    private HashSet<Illness> illnesses;

    private static int nbPatients;

    public Patient (String firstname, String lastname, Double lifePoint, Double age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.lifePoint = lifePoint;
        this.age = age;

        this.illnesses = new HashSet<>();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Double getLifePoint() {
        return lifePoint;
    }

    public Double getAge() {
        return age;
    }

    public HashSet<Illness> getIllnesses() {
        return illnesses;
    }

    public static int getNbPatients() {
        return nbPatients;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setLifePoint(Double lifePoint) {
        this.lifePoint = lifePoint;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public void setIllnesses(HashSet<Illness> illnesses) {
        this.illnesses = illnesses;
    }

    public static void setNbPatients(int nbPatients) {
        Patient.nbPatients = nbPatients;
    }

    public void addIllness(Illness illness) {
        illnesses.add(illness);
    }

    public boolean isIll() {
        return !illnesses.isEmpty();
    }

    public boolean idDead() {
        return this.lifePoint <= 0;
    }

    public void takeCare(Medicine medicine) {
        for (Illness illness : illnesses) {
            illness.treat(medicine);

            if (illness.state()) {
                illnesses.remove(illness);
            }
        }

        if (illnesses.isEmpty()) {
            System.out.println("Patient is cured!");
        }
    }

    public boolean sufferIllness() {
        for (Illness illness : illnesses) {
            if (this.getAge() < 15) {
                illness.strength = (int)(illness.strength * 1.25);
            } else if (this.getAge() > 65) {
                illness.strength = (int)(illness.strength * 1.33);
            }
        }

        return this.isIll();
    }
}
