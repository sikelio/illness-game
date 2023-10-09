package wtf.sikelio;

import java.util.HashSet;
import java.util.Iterator;

public class App 
{
    public static void main(String[] args)
    {
        InitGame game = new InitGame();

        HashSet<Illness> illnesses = game.initIllness();
        HashSet<Medicine> medicines = game.initMedicine();
        HashSet<Patient> patients = game.initPatient();

        int currentYear = 2023;
        int numberOfPatients = patients.size();
        int numberOfCuredPatients = 0;

        System.out.println("Number of patients: " + numberOfPatients);

        while (!patients.isEmpty()) {
            System.out.println("---------------------------------------");
            System.out.println("New round! Current year: " + currentYear);

            Iterator<Patient> patientIterator = patients.iterator();

            boolean gameEndedDueToDeath = false;
            boolean gameEndedDueToCure = false;

            while (patientIterator.hasNext()) {
                Patient patient = patientIterator.next();

                System.out.println("Patient: " + patient.getFirstname() + " " + patient.getLastname() + " - Age: " + patient.getAge() + " - Life Point: " + patient.getLifePoint());

                if (patient.isDead() || !patient.isIll()) {
                    if (patient.isDead()) {
                        gameEndedDueToDeath = true;
                        break;
                    }

                    numberOfCuredPatients++;

                    if (numberOfCuredPatients == numberOfPatients) {
                        gameEndedDueToCure = true;
                        break;
                    }

                    patientIterator.remove();
                }

                Medicine randomMedicine = getRandomMedicine(medicines);
                patient.takeCare(randomMedicine);
                patient.sufferIllness();

                for (Illness illness : patient.getIllnesses()) {
                    patient.setLifePoint(patient.getLifePoint() - illness.evolve());
                }
            }

            if (gameEndedDueToDeath) {
                System.out.println("Game finished due to patient dead!");
                break;
            } else if (gameEndedDueToCure) {
                System.out.println("Game finished due to all patient cured!");
            }

            currentYear++;
        }
    }

    private static Medicine getRandomMedicine(HashSet<Medicine> medicines) {
        int randomIndex = (int) (Math.random() * medicines.size());

        Iterator<Medicine> medicineIterator = medicines.iterator();

        for (int i = 0; i < randomIndex; i++) {
            medicineIterator.next();
        }

        return medicineIterator.next();
    }
}
