package wtf.sikelio;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args)
    {
        InitGame game = new InitGame();

        HashSet<Illness> illnesses = game.initIllness();
        HashSet<Medicine> medicines = game.initMedicine();
        HashSet<Patient> patients = game.initPatient();

        Scanner scanner = new Scanner(System.in);

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

                int numberofMedicine = 0;

                for (Medicine medicine : medicines) {
                    numberofMedicine++;

                    System.out.println("[" + numberofMedicine + "] " + medicine.getName());
                }

                System.out.print("Enter medicine index: ");
                String mededineIndex = scanner.nextLine();
                Medicine[] medicinesArray = medicines.toArray(new Medicine[medicines.size()]);

                patient.takeCare(medicinesArray[Integer.parseInt(mededineIndex)]);
                patient.sufferIllness();

                for (Illness illness : patient.getIllnesses()) {
                    patient.setLifePoint(patient.getLifePoint() - illness.evolve());
                }

                patient.incrementAge();
            }

            if (gameEndedDueToDeath) {
                System.out.println("Game finished due to patient dead!");
                break;
            } else if (gameEndedDueToCure) {
                System.out.println("Game finished due to all patient cured!");
                break;
            }

            currentYear++;
        }
    }
}
