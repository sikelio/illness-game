package wtf.sikelio;

import java.util.HashSet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        InitGame game = new InitGame();

        HashSet<Illness> illnesses = game.initIllness();
        HashSet<Medicine> medicines = game.initMedicine();
        HashSet<Patient> patients = game.initPatient();

        System.out.println(illnesses);
        System.out.println(medicines);

        for (Patient patient : patients) {
            System.out.println(
                patient.getFirstname() + " " + patient.getLastname() + " - Status: " + patient.isIll() + " - Dead: " + patient.idDead()
            );
        }
    }
}
