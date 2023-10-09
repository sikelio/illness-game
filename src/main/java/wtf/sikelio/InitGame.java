package wtf.sikelio;

import com.github.javafaker.Faker;

import java.util.HashSet;

public class InitGame {
    private Faker faker;

    private HashSet<Illness> illnesses;
    private HashSet<Medicine> medicines;
    private HashSet<Patient> patients;

    public InitGame() {
        this.faker = new Faker();

        this.illnesses = new HashSet<>();
        this.medicines = new HashSet<>();
        this.patients = new HashSet<>();
    }

    public HashSet<Illness> initIllness() {
        // Bacteria
        this.illnesses.add(new Bacteria("Gastroenteritis", 100, 1, "Digestive disorders"));
        this.illnesses.add(new Bacteria("Cold", 100, 4, "Sore throat, fatigue, runny nose"));
        this.illnesses.add(new Bacteria("Tuberculosis", 125, 6, "Fever, chest pain, fatigue"));
        this.illnesses.add(new Bacteria("Tetanus", 125, 9, "Pain in jaw and neck muscles"));

        // Virus
        this.illnesses.add(new Virus("Angina", 70, 1, "Sore throat, fatigue"));
        this.illnesses.add(new Virus("Flu", 100, 4, "Influenza-like illness"));
        this.illnesses.add(new Virus("Hepatitis C", 125, 6, "Fever, nausea, vomiting"));
        this.illnesses.add(new Virus("Herpes", 45, 3, "Buttons"));

        // Parasite
        this.illnesses.add(new Parasite("Lice", 20, 1, "Itchy hair"));
        this.illnesses.add(new Parasite("Scabies", 50, 4, "Severe itching of the skin"));
        this.illnesses.add(new Parasite("Tapeworm", 150, 6, "Significant weight loss, Violent stomach ache"));
        this.illnesses.add(new Parasite("Malaria", 300, 9, "Sudden, spiking or constant high fever"));

        return this.illnesses;
    }

    public HashSet<Medicine> initMedicine() {
        // Antibiotic
        this.medicines.add(new Medicine("Amoxicillin", Type.Antibiotic));
        this.medicines.add(new Medicine("Bristopen", Type.Antibiotic));
        this.medicines.add(new Medicine("Clamoxyl", Type.Antibiotic));
        this.medicines.add(new Medicine("Orbenine", Type.Antibiotic));

        // Antiparasite
        this.medicines.add(new Medicine("Prioderm", Type.Antiparasite));
        this.medicines.add(new Medicine("Ascabiol", Type.Antiparasite));
        this.medicines.add(new Medicine("Fluvermal", Type.Antiparasite));
        this.medicines.add(new Medicine("Combantrin", Type.Antiparasite));

        // Antiviral
        this.medicines.add(new Medicine("Aciclovir", Type.Antiviral));
        this.medicines.add(new Medicine("Iduviran", Type.Antiviral));

        return this.medicines;
    }

    public HashSet<Patient> initPatient() {
        for (int i = 0; i < this.faker.number().randomDouble(0, 1, 3); i++) {
            Patient patient = new Patient(
                this.faker.name().firstName(),
                this.faker.name().lastName(),
                this.faker.number().randomDouble(0, 100, 150),
                this.faker.number().randomDouble(0, 0, 100)
            );

            Illness[] illnessesArray = this.illnesses.toArray(new Illness[this.illnesses.size()]);

            for (int j = 0; j < this.faker.number().randomDouble(0, 1, 3); j++) {
                patient.addIllness(illnessesArray[(int) this.faker.number().randomDouble(0, 1, illnessesArray.length)]);
            }

            this.patients.add(patient);
        }

        return this.patients;
    }
}
