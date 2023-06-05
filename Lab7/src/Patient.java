enum RhFactor {
	POSITIVE('+'), NEGATIVE('-');
	
	private char RhSign;
	
	private RhFactor(char sign)
	{
		RhSign = sign;
	}
	
	public char getSign()
	{
		return RhSign;
	}
};

enum BloodType {
	O, A, B, AB;
};

public class Patient {
	private int ID_number;
	private int age;
	private BloodData bloodData;	// Helper class function
	
	public Patient()
	{
		// Set default values in the empty constructor
		ID_number = 0;
		age = 0;
		bloodData = new BloodData();
	}
	public Patient(int ID_number, int age, BloodType bloodType, RhFactor Rh)
	{
		this.ID_number = ID_number;
		this.age = age;
		bloodData = new BloodData(bloodType, Rh);
	}
	public int getID()
	{
		return ID_number;
	}
	public int getAge()
	{
		return age;
	}
	public void displayBlood()
	{
		System.out.println("Blood Type: " + bloodData.typeBlood + bloodData.rh.getSign());
	}
	// Below is the nested class of BloodData inside Patient
	private class BloodData
	{
		private RhFactor rh;
		private BloodType typeBlood;
		public BloodData()
		{
			typeBlood = BloodType.O;
			rh = RhFactor.POSITIVE;
		}
		public BloodData(BloodType b, RhFactor f)
		{
			typeBlood = b;
			rh = f;
		}
	}
}
