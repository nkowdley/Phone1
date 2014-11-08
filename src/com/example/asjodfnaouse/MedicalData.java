package com.example.asjodfnaouse;

public class MedicalData {
	/*private String name;
	private String dob;
	private String iceNumber;
	private String iceName;
	private String allergies;
	private String medicalConditions; */
	private String finalString; 

	public MedicalData(String name, String dob, String iceNumber,
						String iceName, String allergies,
						String medicalConditions)
	{
		StringBuilder superString = new StringBuilder();
		superString.append("AAAAAA~");
		superString.append(name + "~");
		superString.append(dob + "~");
		superString.append(iceNumber + "~");
		superString.append(iceName + "~");
		superString.append(allergies + "~");
		superString.append(medicalConditions + "~");
		
		finalString = superString.toString();
	}
	
	public byte[] toByteArray()
	{
		return finalString.getBytes();
	}
	
}
