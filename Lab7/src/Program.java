
public class Program {

	public static void main(String[] args) {
		Patient Timmy = new Patient();
		System.out.println("Patient ID: " + Timmy.getID() +
				"\nPatient Age: " + Timmy.getAge());
		Timmy.displayBlood();
		
		Patient Spike = new Patient(1337, 19, BloodType.AB, RhFactor.NEGATIVE);
		System.out.println("Patient ID: " + Spike.getID() +
				"\nPatient Age: " + Spike.getAge());
		Spike.displayBlood();
	}
}

/*
Patient ID: 0
Patient Age: 0
Blood Type: O+
Patient ID: 1337
Patient Age: 19
Blood Type: AB-
 */